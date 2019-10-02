package CrazyStudyApp.main;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
//import com.google.gson.Gson;
import java.util.*;

public class PhoneCode
{

	/**
	 * ����6λ������֤��
	 * 
	 * @return ��֤��
	 */
	public static String vcode()
	{
		String vcode = "";
		for (int i = 0; i < 6; i++)
		{
			vcode = vcode + (int) (Math.random() * 9);
		}
		return vcode;
	}

	/**
	 * ����صĲ������͸������ƽ��ж��ŷ��ͣ�ͬʱ����֤�뷵��
	 * 
	 * @param mobile ���͵��ֻ���
	 * @return ������֤��
	 */
	static public String getPhonemsg(String mobile)
	{

		// �ֻ�����У��
		// System.out.println(mobile);
		if (mobile == null || mobile == "")
		{
			System.out.println("�ֻ���Ϊ��");
			return "";
		}

		// ���ó�ʱʱ��-�����е���
//		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
//		System.setProperty("sun.net.client.defaultReadTimeout", "10000");
//		
		// ��ʼ��ascClient��Ҫ�ļ�������
		final String product = "Dysmsapi";
		; // ����API��Ʒ���ƣ����Ų�Ʒ���̶��������޸ģ�
		final String domain = "dysmsapi.aliyuncs.com"; // ����API��Ʒ�������ӿڵ�ַ�̶��������޸ģ�
		// �滻�����AK
		final String accessKeyId = "LTAI4FrcMihcyjax8ZFXA56b";// ���accessKeyId
		final String accessKeySecret = "htTk40wKwtX29H8OurX6GRnXqUnU1G";// ���accessKeySecret��
		// ��ʼ��ascClient,��ʱ��֧�ֶ�region
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
		try
		{
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		} catch (ClientException e1)
		{
			e1.printStackTrace();
		}

		// ��ȡ��֤��
		String code = vcode();

		IAcsClient acsClient = new DefaultAcsClient(profile);
		// ��װ�������
		SendSmsRequest request = new SendSmsRequest();
		// ʹ��post�ύ
		request.setMethod(MethodType.POST);
		// ����:�������ֻ��š�֧���Զ��ŷָ�����ʽ�����������ã���������Ϊ1000���ֻ�����,������������ڵ������ü�ʱ�������ӳ�,��֤�����͵Ķ����Ƽ�ʹ�õ������õķ�ʽ
		request.setPhoneNumbers(mobile);
		// ����:����ǩ��-���ڶ��ſ���̨���ҵ�
		request.setSignName("��ѧϰ");
		// ����:����ģ��-���ڶ��ſ���̨���ҵ�
		request.setTemplateCode("SMS_174271163");

		// ��ѡ:ģ���еı����滻JSON��,��ģ������Ϊ"�װ���${name},������֤��Ϊ${code}"ʱ,�˴���ֵΪ
		// ������ʾ:���JSON����Ҫ�����з�,����ձ�׼��JSONЭ��Ի��з���Ҫ��,������������а���\r\n�������JSON����Ҫ��ʾ��\\r\\n,����ᵼ��JSON�ڷ���˽���ʧ��
		request.setTemplateParam("{ \"code\":\"" + code + "\"}");

		// ��ѡ-���ж�����չ��(�����������û�����Դ��ֶ�)
		// request.setSmsUpExtendCode("90997");
		// ��ѡ:outIdΪ�ṩ��ҵ����չ�ֶ�,�����ڶ��Ż�ִ��Ϣ�н���ֵ���ظ�������
		request.setOutId("yourOutId");
		// ����ʧ���������ClientException�쳣
		SendSmsResponse sendSmsResponse;
		try
		{
			sendSmsResponse = acsClient.getAcsResponse(request);
			if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK"))
			{
				// ����ɹ�
				System.out.println("��ȡ��֤��ɹ�������");
			} else
			{
				// �����֤������������������������ԭ��
				System.out.println(sendSmsResponse.getCode());
				System.out.println("��ȡ��֤��ʧ��...");
			}
		} catch (ServerException e)
		{
			e.printStackTrace();
			return "����ϵͳά������ʱ�޷�ע�ᣡ����";
		} catch (ClientException e)
		{
			e.printStackTrace();
			return "����ϵͳά������ʱ�޷�ע�ᣡ����";
		}
		return code;
	}
}
