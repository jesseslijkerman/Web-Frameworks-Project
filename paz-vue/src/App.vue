<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<template>
  <Header></Header>
  <NavBar></NavBar>
  <CabinsOverview32></CabinsOverview32>
  <CabinsOverview31></CabinsOverview31>
</template>

<script>
import Header from "@/components/Header";
import NavBar from "@/components/NavBar";
import CabinsOverview31 from "@/components/cabins/Overview31";
import CabinsOverview32 from "@/components/cabins/Overview32";


export default {
  name: 'App',
  components: {
    Header,
    NavBar,
    CabinsOverview31,
    CabinsOverview32
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

body{
  margin: 0;
}

h1{
  margin: 0;
}

button{
  background-color: goldenrod;
  border: none;
  padding: 5px;
}

button:hover{
  background-color: darkgoldenrod;
}
</style>
