package pl.bottega.jsfex.user.api;

/**
 * Created by maciuch on 04.10.16.
 */
public class UserQuery {

    private String query;

    private String sortBy;

    private SortOrder sortOrder = SortOrder.ASC;

    private int pageNumber;

    private int perPage;

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public SortOrder getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public long getOffset() {
        return perPage * (pageNumber - 1);
    }
}
