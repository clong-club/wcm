package com.pavilionking.wcm.common.constant.thymeleaf;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
public class FreemarkerUtils {
	@Autowired
	private TemplateEngine engine;
	/**
	 * 生成静态文件
	 * @param freeTempName 模板名称
	 * @param context 数据内容
	 * @param outFilePath 输出路径
	 * @return
	 */
	public boolean process(String freeTempName,Context context,String outFilePath) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(outFilePath);
			engine.process(freeTempName, context,fileWriter);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
}