package com.amao.gmall.admin.oos.component;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.amao.gmall.to.OssPolicyResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by atguigu 5/17.
 */
@Slf4j
@Service
public class OssCompent {

	@Value("${aliyun.oss.policy.expire}")
	private int ALIYUN_OSS_EXPIRE;
	@Value("${aliyun.oss.maxSize}")
	private int ALIYUN_OSS_MAX_SIZE;
	@Value("${aliyun.oss.bucketName}")
	private String ALIYUN_OSS_BUCKET_NAME;
	@Value("${aliyun.oss.endpoint}")
	private String ALIYUN_OSS_ENDPOINT;
	@Value("${aliyun.oss.dir.prefix}")
	private String ALIYUN_OSS_DIR_PREFIX;

	@Value("${aliyun.oss.accessKeyId}")
	private String ALIYUN_OSS_KEY;
	@Value("${aliyun.oss.accessKeySecret}")
	private String ALIYUN_OSS_SECRET_KEY;

	@Value("${aliyun.oss.action}")
	private String ALIYUN_OSS_ACTION;

	@Autowired
	private OSSClient ossClient;

	/**
	 * 签名生成
	 */
	public OssPolicyResult policy() {

//		// 1 初始化用户身份信息(secretId, secretKey)
//		COSCredentials cred = new BasicCOSCredentials(COS_SECREID, COS_SECREKEY);
//		// 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
//		ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));
//
//
//		// 3 生成 cos 客户端
//		COSClient cosclient = new COSClient(cred, clientConfig);
//		// bucket名需包含appid
//		String bucketName = COS_BUCKET_NAME;
//		String key = "123.zip";
//
//		// 签名有效期
//		Date expirationTime = new Date(System.currentTimeMillis() + COS_EXPIRE * 1000);
//
//		// 生成预签名上传 URL
//		URL url = cosclient.generatePresignedUrl(bucketName, key, expirationTime, HttpMethodName.POST);
//		String s = url.toString();

        //*****************************************************************

		OssPolicyResult result = new OssPolicyResult();
		// 存储目录
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dir = ALIYUN_OSS_DIR_PREFIX+sdf.format(new Date());
		// 签名有效期
		long expireEndTime = System.currentTimeMillis() + ALIYUN_OSS_EXPIRE * 1000;
		Date expiration = new Date(expireEndTime);
		// 文件大小
		long maxSize = ALIYUN_OSS_MAX_SIZE * 1024 * 1024;
		// 提交节点
		String action = "http://" + ALIYUN_OSS_ACTION;
		try {
			PolicyConditions policyConds = new PolicyConditions();
			policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, maxSize);
			policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);
			String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
			byte[] binaryData = postPolicy.getBytes("utf-8");
			String policy = BinaryUtil.toBase64String(binaryData);
			String signature = ossClient.calculatePostSignature(postPolicy);
			// 返回结果
			result.setAccessKeyId(ossClient.getCredentialsProvider().getCredentials().getAccessKeyId());
			result.setPolicy(policy);
			result.setSignature(signature);
			result.setDir(dir);
			result.setHost(action);
		} catch (Exception e) {
			log.error("签名生成失败", e);
		}
		return result;
	}

	@Bean
	public OSSClient ossClient(){

		//public OSSClient(String endpoint, String accessKeyId, String secretAccessKey)
		OSSClient ossClient = new OSSClient(ALIYUN_OSS_ENDPOINT, ALIYUN_OSS_KEY, ALIYUN_OSS_SECRET_KEY);
		return ossClient;
	}




}
