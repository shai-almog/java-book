
// from https://stackoverflow.com/a/28325084/756809 this is pretty
// simplistic. One should use big decimal for these things...
function calculateValue(total, year, rate) {
  var interest = rate / 100 + 1;
  return parseFloat((total * Math.pow(interest, year)).toFixed(4));
}