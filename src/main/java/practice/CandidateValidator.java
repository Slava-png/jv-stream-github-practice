package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_TIME_IN_UKR = 10;
    private static final int FROM_YEAR = 0;
    private static final int TO_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && Integer.parseInt(years[TO_YEAR])
                - Integer.parseInt(years[FROM_YEAR]) >= MIN_TIME_IN_UKR;
    }
}
