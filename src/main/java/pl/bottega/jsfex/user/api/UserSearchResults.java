package pl.bottega.jsfex.user.api;

import pl.bottega.jsfex.user.model.User;

import java.util.Collection;

/**
 * Created by maciuch on 04.10.16.
 */
public class UserSearchResults {

    private Collection<User> users;

    private int perPage, pageNumber, totalCount;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int pagesCount() {
        return (this.totalCount / perPage) + 1;
    }

    public boolean hasNextPage() {
        return pageNumber < pagesCount();
    }

    public boolean hasPrevPage() {
        return pageNumber > 1;
    }
}
