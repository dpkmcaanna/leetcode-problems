class Solution {
    public long dividePlayers(int[] skill) {
        int totalSkill = 0, teams = skill.length / 2;
        Map<Integer, Integer> skillFreq = new HashMap<>();

        for(int s : skill) {
            skillFreq.put(s, skillFreq.getOrDefault(s, 0) + 1);
            totalSkill += s;
        }
    
        if(totalSkill % teams != 0) return -1;

        int skillPerTeam = totalSkill / teams;

        long sum = 0;
        for(int s : skill) {
            if(skillFreq.get(s) == 0)  continue;
          
            skillFreq.put(s, skillFreq.get(s) - 1);
            int pair = skillPerTeam - s;

            if(!skillFreq.containsKey(pair) || skillFreq.get(pair) == 0) {
                return -1; 
            }

            skillFreq.put(pair, skillFreq.get(pair) - 1);
            
            sum = sum + ((long) s *  (long) pair);
        }
        return sum;
    }
}