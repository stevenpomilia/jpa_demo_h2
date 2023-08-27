// an example of some REST endpoints to test
const endpoints = [
  // 'https://rickandmortyapi.com/api/character/707',
  // 'https://rickandmortyapi.com/api/location/9',
  //  disable to test demo h2 spring app running locally, e.g.
  "http://localhost:8888/api/pets/",
  "http://localhost:8888/api/pets/1",
  "http://localhost:8888/api/pets/2",
  "http://localhost:8888/api/pets/3",
  "http://localhost:8888/api/pets/4",
  "http://localhost:8888/api/pets/5",
  "http://localhost:8888/api/pets/add",
  "http://localhost:8888/api/pets/delete/6",
  "http://localhost:8888/api/pets/delete/1",
];
const onSuccess = (response) => {
  console.log(response);
};
const onFailure = (error) => {
  console.log(error);
};

console.log("initiating test...");
endpoints.forEach((request) => {
  fetch(request).then(onSuccess).catch(onFailure);
});
console.log("all done!");
