package com.uniroma3.esamesiw2024.utilies.thymeleaf;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationUtil {
	
	private static final String TEMPLATES = "/templates";
	private static final String[] EXCLUDED = {"fragments"};
	
	/**
	 * Usare questo metodo se le pagine si trovano tutte nella cartella "templates" (root)
	 * @param webPageSuffix
	 * @return
	 */
	public static List<String> getRootApplicationPages(String webPageSuffix)
	{
		List<String> listaPagine = new ArrayList<String>();
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		try {
			Resource[] resources = resourcePatternResolver.getResources(TEMPLATES+"/**"+webPageSuffix);
			for(Resource r: resources) {
				String page = r.getFilename();
				String pageName = page.substring(0, page.lastIndexOf(webPageSuffix));
				listaPagine.add(pageName);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaPagine;
	}
	
	/**
	 * Usare questo metodo quando le pagine (template) applicative si trovano dentro cartelle annidate in "templates" (root)
	 * @param webPageSuffix
	 * @return
	 */
	public static List<String> getAllApplicationPages(String webPageSuffix)
	{
		List<String> listaPagine = new ArrayList<String>();
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		try {
			Resource[] resources = resourcePatternResolver.getResources(TEMPLATES+"/**");
			for(Resource r: resources) 
			{
				String page = r.getURL().toString();
				page = page.substring(page.toString().indexOf(TEMPLATES)+TEMPLATES.length()+1);
				if(page.endsWith(webPageSuffix)) 
				{
					page = page.substring(0, page.lastIndexOf(webPageSuffix));
					if(isTemplateIncluded(page)) {
						listaPagine.add(page);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaPagine;
	}
	
	/**
	 * Verifica se il template è da includere o meno all'interno della configurazione applicativa
	 * @param template
	 * @return
	 */
	private static boolean isTemplateIncluded(String template) {
		boolean included = true;
		for(String escluso: EXCLUDED) {
			if(template.startsWith(escluso+"/")) {
				included = false;
				break;
			}
		}
		return included;
	}

}
