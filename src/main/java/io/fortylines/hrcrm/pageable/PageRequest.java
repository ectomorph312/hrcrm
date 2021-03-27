package io.fortylines.hrcrm.pageable;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageRequest implements Pageable {

    private int limit;
    private int offset;
    private Sort sort;

    public PageRequest(int limit, int offset, String sortBy) {
        this.limit = limit;
        this.offset = offset;
        if (null == sortBy) {
            this.sort = Sort.by("id");
        } else {
            this.sort = Sort.by(sortBy);
        }
    }

    @Override
    public int getPageNumber() {
        return 0;
    }

    @Override
    public int getPageSize() {
        return limit;
    }

    @Override
    public long getOffset() {
        return offset;
    }

    @Override
    public Sort getSort() {
        return sort;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}
