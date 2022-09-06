package com.example.playground;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AlgorithmJavaTest {


    @Test
    public void algorithm07() {
        String skill = "CBD";
        String[] skill_trees = new String[] {"BACDE", "CBADF", "AECB", "BDA"};

        solution07_2(skill, skill_trees);
    }

    public int solution07(String skill, String[] skill_trees) {
        int answer = 0;

        ArrayList<String> skillArray = new ArrayList<>(Arrays.asList(skill.split("")));

        for (String tree: skill_trees) {
            Boolean isStopFlag = false;

            ArrayList<String> targetSkillArray = (ArrayList<String>) skillArray.clone();

            List<String> treeArray = new ArrayList<>(Arrays.asList(tree.split("")));

            while (!targetSkillArray.isEmpty()) {
                String target = targetSkillArray.remove(0);

                // 찾았으면
                if (treeArray.contains(target)) {
                    treeArray = treeArray.subList(treeArray.indexOf(target) + 1, treeArray.size());
                } else {
                    isStopFlag = true;
                    break;
                }
            }

            if (!isStopFlag) {
                answer += 1;
            }
        }

        System.out.println("!!! DEBUG !!!" + answer);
        return answer;
    }

    public int solution07_2(String skill, String[] skill_trees) {
        int answer = 0;

        ArrayList<String> skillArray = new ArrayList<>(Arrays.asList(skill.split("")));

        for (String tree: skill_trees) {
            boolean isFailFlag = false; // 실패한 경우 true Flag
            boolean flag1 = false; // 못찾았을 때 true 되는 Flag

            ArrayList<Integer> indexs = new ArrayList<>();
            for (String target: skillArray) {
                List<String> treeArray = new ArrayList<>(Arrays.asList(tree.split("")));

                int skillIndex = treeArray.indexOf(target);
                if (skillIndex == -1) {
                    flag1 = true;
                } else {
                    if (flag1) {
                        isFailFlag = true;
                        break;
                    } else {
                        indexs.add(skillIndex);
                    }
                }
            }

            if (!isFailFlag) {
                ArrayList<Integer> sortedIndexs = (ArrayList<Integer>) indexs.clone();
                Collections.sort(sortedIndexs);
                if(indexs.toString().equals(sortedIndexs.toString())) {
                    answer ++;
                }
            }
        }

        return answer;
    }
}
