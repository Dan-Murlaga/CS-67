/**
 * A class representing a movie with a title, running time, release year, and rating.
 *  Created by Professor Urness with the assistance of Claude
 */
public class Movie {

    private String title;       // title of the movie
    private int runningTime;    // running time in minutes
    private int releaseYear;    // year the movie was released
    private String rating;      // MPAA rating (e.g., "PG-13")

    /**
     * Constructs a new Movie object with the given attributes.
     */
    public Movie(String title, int runningTime, int releaseYear, String rating) {
        this.title = title;
        this.runningTime = runningTime;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    /**
     * getTitle returns the title of the movie.
     */
    public String getTitle() {
        return title;
    }

    /**
     * getRunningTime returns the running time of the movie.
     */
    public int getRunningTime() {
        return runningTime;
    }

    /**
     * getReleaseYear returns the year the movie was released.
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * getRating returns the MPAA rating of the movie.
     */
    public String getRating() {
        return rating;
    }

    /**
     * Two movies are equal if all of their attributes are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Movie other = (Movie) obj;
        return this.runningTime == other.runningTime
                && this.releaseYear == other.releaseYear
                && java.util.Objects.equals(this.title, other.title)
                && java.util.Objects.equals(this.rating, other.rating);
    }

    /**
     * Returns a hash code consistent with equals: equal movies
     * produce the same hash code.
     * @return the hash code for this movie
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (title == null ? 0 : title.hashCode());
        result = 31 * result + runningTime;
        result = 31 * result + releaseYear;
        result = 31 * result + (rating == null ? 0 : rating.hashCode());
        return result;
    }

    /**
     * Returns a string representation of the movie.
     * @return a string representation of the movie
     */
    @Override
    public String toString() {
        return title;
    }
}
