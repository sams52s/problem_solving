package javaProblemsSolution.october;

class SentenceSimilarityIII {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] sent1Arr = sentence1.split(" ");
        String[] sent2Arr = sentence2.split(" ");
        if (sent2Arr.length > sent1Arr.length) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        int prefix = 0;
        while (prefix < sent2Arr.length && sent1Arr[prefix].equals(sent2Arr[prefix])) {
            prefix++;
        }
        int suffix = 0;
        while (suffix < sent2Arr.length
                && sent1Arr[sent1Arr.length - 1 - suffix].equals(sent2Arr[sent2Arr.length - 1 - suffix])) {
            suffix++;
        }
        return prefix + suffix >= sent2Arr.length;
    }
}
