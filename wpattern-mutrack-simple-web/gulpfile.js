// https://github.com/AveVlad/gulp-connect
// https://www.npmjs.com/package/gulp-inject

var gulp = require('gulp');
var connect = require('gulp-connect');
var inject = require('gulp-inject');

gulp.task('index', function () {
  var target = gulp.src('app/index.html');

  var source = gulp.src(['app/src/**/*.js', 'app/src/**/*.css'], {read: false});

  return target.pipe(inject(source, {relative: true})).pipe(gulp.dest('app/'));
});

gulp.task('connect', function() {
  connect.server({
    root: 'app',
    livereload: true,
    port: 8081
  });
});

gulp.task('html', function () {
  gulp.src('./app/**/*.html')
    .pipe(connect.reload());
});

gulp.task('js', function () {
  gulp.src('./app/**/*.js')
    .pipe(connect.reload());
});

gulp.task('css', function () {
  gulp.src('./app/**/*.css')
    .pipe(connect.reload());
});

gulp.task('watch', function () {
  gulp.watch(['./app/**/*.html'], ['html']);
  gulp.watch(['./app/**/*.js'], ['js']);
  gulp.watch(['./app/**/*.css'], ['css']);
});

gulp.task('default', ['connect', 'watch', 'index']);
