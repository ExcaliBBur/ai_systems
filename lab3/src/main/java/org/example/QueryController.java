package org.example;

import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;

import java.util.Map;

/**
 * Class to manage query
 */
public class QueryController {
    private Query query;

    /**
     * Initializing query
     */
    public void init() {
        this.query = new Query("consult", new Term[]
                {new Atom("src/main/resources/prolog.pl")});
        query.hasSolution();
    }

    /**
     * Set query
     * @param query new query
     */
    public void setQuery(Query query) {
        this.query = query;
    }

    /**
     * Get query
     * @return query
     */
    public Query getQuery() {
        return this.query;
    }

    /**
     * Get results of query invoking
     * @return result string
     */
    public Map<String, Term>[] getResults() {
        return this.query.allSolutions();
    }

}
