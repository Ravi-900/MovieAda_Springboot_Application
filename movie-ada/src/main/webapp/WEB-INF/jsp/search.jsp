<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <link rel="stylesheet" href="../css/search.css" />
    <title>Movie Ada</title>
  </head>
  <body>
    <!-- Navbar Section -->
    <section id="Navbar" class="Navbar-Search">
      <div class="Navbar-Logo">
        <a href="/">Movie Ada</a>
      </div>
      <div class="Navbar-Search">
        <form method="post">
          <div class="searchBox">
            <input
              class="searchInput"
              type="text"
              name="searchQuery"
              placeholder="Search" />
            <input class="searchButton" type="submit" Value="Search" />
          </div>
        </form>
      </div>
    </section>

    <!-- Search Results -->
    <section id="Search">
      <h2>Search Results</h2>
      <div class="wrapper">
        <c:forEach var="movie" items="${Movies}">
          <div class="item">
            <div class="movie-tile">
              <a name="${movie.title}" href="../${movie.id}">
                <img
                  src="https://image.tmdb.org/t/p/original${movie.poster_path}"
                  onerror="if (this.src != 'error.jpg') this.src = '/images/defaultMovieThumbnail.jpg';" />
              </a>
            </div>
          </div>
        </c:forEach>
      </div>
    </section>
  </body>
</html>
