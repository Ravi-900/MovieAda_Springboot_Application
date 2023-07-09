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

    <link rel="stylesheet" href="css/movieAda.css" />
    <title>Movie Ada</title>
  </head>
  <body>
    <!-- Navbar Section -->
    <section id="Navbar">
      <div class="Navbar-Logo">
        <a>Movie Ada</a>
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

    <!-- upComingMovies -->
    <section id="Carousel">
      <div
        id="carouselExampleIndicators"
        class="carousel slide"
        data-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <div
              id="content_hero"
              class="center-content hero-ontop"
              style="
                background-image: url(https://image.tmdb.org/t/p/original${WatchNext[0].background}),
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
                    <h1
                      style="
                        overflow: hidden;
                        display: -webkit-box;
                        -webkit-line-clamp: 1;
                        -webkit-box-orient: vertical;
                      ">
                      ${WatchNext[0].title}
                    </h1>
                    <p
                      style="
                        overflow: hidden;
                        display: -webkit-box;
                        -webkit-line-clamp: 3;
                        -webkit-box-orient: vertical;
                      ">
                      ${WatchNext[0].summary}
                    </p>
                    <div class="buttons">
                      <span class="certificate">MA</span>
                      <a
                        href="https://www.youtube.com/watch?v=${WatchNext[0].videoKey}"
                        data-vbtype="video"
                        class="venobox btn btn-default vbox-item">
                        <span>Watch Now</span>
                      </a>
                      <div class="star-rating">
                        <i class="material-icons">${WatchNext[0].ratings}</i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <c:forEach var="movie" items="${WatchNext}">
            <c:if test="${movie.id != WatchNext[0].id}">
              <div class="carousel-item">
                <div
                  id="content_hero"
                  class="center-content hero-ontop"
                  style="
                    background-image: url(https://image.tmdb.org/t/p/original${movie.background}),
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
                        <h1
                          style="
                            overflow: hidden;
                            display: -webkit-box;
                            -webkit-line-clamp: 1;
                            -webkit-box-orient: vertical;
                          ">
                          ${movie.title}
                        </h1>
                        <p
                          style="
                            overflow: hidden;
                            display: -webkit-box;
                            -webkit-line-clamp: 3;
                            -webkit-box-orient: vertical;
                          ">
                          ${movie.summary}
                        </p>
                        <div class="buttons">
                          <span class="certificate">MA</span>
                          <a
                            href="https://www.youtube.com/watch?v=${movie.videoKey}"
                            data-vbtype="video"
                            class="venobox btn btn-default vbox-item">
                            <span>Watch Now</span>
                          </a>
                          <div class="star-rating">
                            <i class="material-icons">${movie.ratings}</i>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </c:if>
          </c:forEach>
        </div>
        <a
          class="carousel-control-prev"
          href="#carouselExampleIndicators"
          role="button"
          data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a
          class="carousel-control-next"
          href="#carouselExampleIndicators"
          role="button"
          data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </section>

    <!-- Categories Section -->
    <c:forEach var="categoryMovies" items="${MoviesCategory}" varStatus="loop">
      <section id="Movies">
        <h2>${CategoryTitles[loop.index]}</h2>
        <div class="wrapper">
          <c:forEach var="movie" items="${categoryMovies}">
            <div class="item">
              <div class="movie-tile">
                <a name="${movie.title}" href="${movie.id}">
                  <img
                    src="https://image.tmdb.org/t/p/original${movie.poster}"
                    onerror="if (this.src != 'error.jpg') this.src = '/images/defaultMovieThumbnail.jpg';" />
                </a>
              </div>
            </div>
          </c:forEach>
        </div>
      </section>
    </c:forEach>

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
