public class DividePlayersIntoTeamsofEqualSkill {
    public static void main(String[] args) {
        DividePlayersIntoTeamsofEqualSkill obj = new DividePlayersIntoTeamsofEqualSkill();
        int[] skill = {1, 2, 3, 4, 5, 6};
        long result = obj.dividePlayers(skill);
        System.out.println(result); // Output: 35
    }
    public static long dividePlayers(int[] skill) {
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