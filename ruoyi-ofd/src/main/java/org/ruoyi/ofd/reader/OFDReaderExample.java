package org.ruoyi.ofd.reader;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.ofdrw.converter.export.HTMLExporter;
import org.ofdrw.converter.export.ImageExporter;
import org.ofdrw.converter.export.OFDExporter;
import org.ofdrw.converter.export.PDFExporterPDFBox;
import org.ofdrw.converter.export.SVGExporter;
import org.ofdrw.converter.export.TextExporter;
import org.ofdrw.core.basicStructure.pageObj.layer.CT_Layer;
import org.ofdrw.core.basicStructure.pageObj.layer.PageBlockType;
import org.ofdrw.core.basicStructure.pageObj.layer.block.TextObject;
import org.ofdrw.reader.OFDReader;
import org.ofdrw.reader.PageInfo;

public class OFDReaderExample {
	public static void main(String[] args) {
		try {
			Path ofdPath = Paths.get("src/test/resources/ofd-test01.ofd");
			Path pdfPath = Paths.get("target/ofd-test01.pdf");
			Path txtPath = Paths.get("target/ofd-test01.txt");
			Path svgPath = Paths.get("target/ofd-test01-ofd/");
//			try (OFDExporter exporter = new PDFExporterPDFBox(ofdPath, pdfPath)) {
//				exporter.export();
//			}
			
			try (TextExporter exporter = new TextExporter(ofdPath, txtPath)) {
			    exporter.export();
			}
			
			try (SVGExporter exporter = new SVGExporter(ofdPath, svgPath, 15d)) {
			    exporter.export();
			}
			
			Path imgDirPath = Paths.get("target/ofd-test01-ofd/");
			try (ImageExporter exporter = new ImageExporter(ofdPath, imgDirPath, "PNG", 20d)) {
			    exporter.export();
			}
			
			Path htmlPath = Paths.get("target/ofd-test01.html");
			try (HTMLExporter exporter = new HTMLExporter(ofdPath, htmlPath)) {
			    exporter.export();
			}
			
	        try (OFDReader reader = new OFDReader(ofdPath)) {
	            System.out.println("=== OFD文档信息 ===");
	            System.out.println("页数: " + reader.getNumberOfPages());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			
//			OFDReader ofdReader = new OFDReader(ofdPath);
//			List<PageInfo> pageInfoList = ofdReader.getPageList();
//			for (PageInfo pageInfo : pageInfoList) {
//				System.out.println(pageInfo.getPageN());
//				List <CT_Layer> ctLayerList = pageInfo.getAllLayer();
//				for (CT_Layer ctLayer : ctLayerList) {
//					System.out.println(ctLayer.getText());
//					List<PageBlockType> pageBlockTypeList = ctLayer.getPageBlocks();
//					for (PageBlockType pageBlockType : pageBlockTypeList) {
//						System.out.println(pageBlockType.getText());
//					}
//				}
//			}

			try (OFDReader ofdReader = new OFDReader(ofdPath)) {
				System.out.println("=== OFD文档信息 ===");
				System.out.println("页数: " + ofdReader.getNumberOfPages());

				List<PageInfo> pageInfoList = ofdReader.getPageList();
				int pageNum = 1;
				for (PageInfo pageInfo : pageInfoList) {
					System.out.println("\n--- 第 " + pageNum + " 页 ---");

					List<CT_Layer> ctLayerList = pageInfo.getAllLayer();
					for (CT_Layer ctLayer : ctLayerList) {
						List<PageBlockType> pageBlockTypeList = ctLayer.getPageBlocks();
						for (PageBlockType pageBlockType : pageBlockTypeList) {
							// 提取文本对象中的文本内容
							if (pageBlockType instanceof TextObject) {
								TextObject textObj = (TextObject) pageBlockType;
								String textContent = textObj.getText();
								if (textContent != null && !textContent.trim().isEmpty()) {
									System.out.println("文本内容: " + textContent);
								}
							}
						}
					}
					pageNum++;
				}
            } catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}