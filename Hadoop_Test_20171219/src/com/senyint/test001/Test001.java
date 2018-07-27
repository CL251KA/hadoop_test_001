package com.senyint.test001;

import java.io.InputStream;
import java.net.URL;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

public class Test001 {
	
	private static final String HDFS_PATH = "hdfs://172.16.100.147:9000/hello";
	
	@Test
	public void app001(){
		try {
			
			URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
			
			URL url = new URL(HDFS_PATH);
			
			final InputStream in = url.openStream();
			
			/**
			 * @param in	������	
			 * @param out	�����	System.out���������̨
			 * @param buffSize	��������С	1024
			 * @param close	�Ƿ�ر��� boolean	true�����ر���
			 */
			IOUtils.copyBytes(in, System.out, 1024, true);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
}
