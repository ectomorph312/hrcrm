package io.fortylines.hrcrm.pageable;

public class CandidatePageRequest extends PageRequest {
    public CandidatePageRequest(int limit, int offset, String sortBy) {
        super(limit, offset, sortBy);
    }
}
