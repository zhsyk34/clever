package com.dnk.clever.door.vo;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Archimedes on 2016-08-10.
 */
public class EasyTreeTest {

	@Test
	public void test() throws JsonProcessingException {
		EasyTree root = new EasyTree();
		root.setId("1");
		root.setText("root");
		root.setState(EasyTree.State.OPEN);

		List<EasyTree> first = new ArrayList<>();
		for (int i = 1; i < 4; i++) {
			EasyTree tree = new EasyTree();
			tree.setText("1-" + i);
			tree.setChecked(i % 3 == 0);

			first.add(tree);
		}

		root.setChildren(first);

	}
}