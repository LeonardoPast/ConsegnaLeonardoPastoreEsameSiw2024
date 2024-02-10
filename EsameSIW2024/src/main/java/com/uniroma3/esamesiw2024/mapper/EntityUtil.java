package com.uniroma3.esamesiw2024.mapper;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class EntityUtil {
	
	public static <T> List<T> mapList(ModelMapper modelMapper, Class<T> destinationClass, Object[] objList) {
		List<T> destObjectList = null;
		if (objList != null && objList.length > 0) {
			destObjectList = new ArrayList<T>();
			for (Object o : objList) {
				destObjectList.add(modelMapper.map(o, destinationClass));
			}
		}
		return destObjectList;
	}
}
