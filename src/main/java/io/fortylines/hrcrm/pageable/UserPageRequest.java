package io.fortylines.hrcrm.pageable;

public class UserPageRequest extends PageRequest {
    public UserPageRequest(int limit, int offset, String sortBy) {
        super(limit, offset, sortBy);
    }
}
