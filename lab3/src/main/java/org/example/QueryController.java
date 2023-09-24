package org.example;

import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;

import java.util.Map;

public class QueryController {
    private Query query;

    public void init() {
        this.query = new Query("consult", new Term[]
                {new Atom("src/main/resources/prolog.pl")});
        query.hasSolution();
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public Query getQuery() {
        return this.query;
    }

    public Map<String, Term>[] getResults() {
        return this.query.allSolutions();
    }

}
