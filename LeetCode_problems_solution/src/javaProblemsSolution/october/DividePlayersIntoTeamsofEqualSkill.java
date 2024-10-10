package javaProblemsSolution.october;

import java.util.Arrays;

class DividePlayersIntoTeamsofEqualSkill {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int tempSub = skill[0] + skill[skill.length - 1];
        long result = 0;
        for (int i = 0; i < skill.length/2; i++) {
           if (skill[i] + skill[skill.length - i - 1] != tempSub) {
                return -1;
            }
             result += (long) skill[i] * skill[skill.length - i - 1];
        }
        return result;
    }
}
