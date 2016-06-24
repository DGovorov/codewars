package stringTasks;

/**
 * Deoxyribonucleic acid (DNA) is a chemical found in the nucleus of cells and carries the "instructions" for
 * the development and functioning of living organisms.
 * In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G". You have function with one side
 * of the DNA (string, except for Haskell); you need to get the other complementary side. DNA strand is never empty
 * or there is no DNA at all (again, except for Haskell).
 * Created by Dim on 24.06.2016.
 */
public class ComplementaryDNA {
    public static void main(String[] args) {
        String complementary = makeComplement("GTAT");
        System.out.println(complementary);
    }

    public static String makeComplement(String dna) {
        char[] chars = dna.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'A':
                    chars[i] = 'T';
                    break;
                case 'T':
                    chars[i] = 'A';
                    break;
                case 'C':
                    chars[i] = 'G';
                    break;
                case 'G':
                    chars[i] = 'C';
                    break;
                default:
                    break;
            }
        }
        return String.copyValueOf(chars);
    }
}
