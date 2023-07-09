<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous" />

    <link rel="stylesheet" href="css/movie.css" />
    <title>Movie Ada</title>
  </head>
  <body>
    <!-- Navbar Section -->
    <section id="Navbar">
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

    <!-- hero section -->

    <div
      id="content_hero"
      class="center-content hero-ontop"
      style="
        background-image: url(https://image.tmdb.org/t/p/original${Movie.backdrop_path}),
          url('/images/defaultImageBg.jpg');
      ">
      <div class="container">
        <div
          class="row blurb scrollme animateme"
          data-when="exit"
          data-from="0"
          data-to="1"
          data-opacity="0"
          data-translatey="100">
          <div class="col-md-9">
            <span class="title">
              <c:forEach var="genre" items="${Movie.genres}">
                ${genre.name}
              </c:forEach>
            </span>
            <h1>${Movie.title}</h1>
            <p>${Movie.overview}</p>
            <div class="buttons">
              <span class="certificate">MA</span>
              <a
                href="https://youtu.be/RhFMIRuHAL4"
                data-vbtype="video"
                class="venobox btn btn-default vbox-item">
                <span>Watch Now</span>
              </a>
              <div class="star-rating">
                <i class="material-icons">${Movie.vote_average}</i>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- related movies section -->
    <section id="Movies">
      <div class="Container">
        <h2>Related MOVIES</h2>
        <div class="row Movies">
          <c:forEach var="movie" items="${Movies}">
            <div class="filter col-lg-2 col-md-3 col-sm-4 col-6">
              <a name="${movie.title}" href="../${movie.id}">
                <img
                  src="https://image.tmdb.org/t/p/original${movie.poster_path}"
                  onerror="if (this.src != 'error.jpg') this.src = '/images/defaultMovieThumbnail.jpg';" />
              </a>
            </div>
          </c:forEach>
        </div>
      </div>
    </section>

    <script
      src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
      integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
      crossorigin="anonymous"></script>
    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
      integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
      crossorigin="anonymous"></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
      integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
      crossorigin="anonymous"></script>
  </body>
</html>
