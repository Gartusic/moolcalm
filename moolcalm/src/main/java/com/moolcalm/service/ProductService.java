package com.moolcalm.service;

import java.util.List;

import com.moolcalm.domain.ProductVO;

public interface ProductService {
		//�����ϱ�
		public void buy(ProductVO product);
		//��ǰ ��ϸ���Ʈ(��������)
		public ProductVO get(String p_setname);
		//��ǰ ��ϸ���Ʈ(���������)
		public List<ProductVO> getList();
		
		//����
}
