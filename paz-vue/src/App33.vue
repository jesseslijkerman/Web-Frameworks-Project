<template>
  <Header></Header>
  <NavBar></NavBar>
  <router-view></router-view>

</template>

<script>
import Header from "@/components/Header";
import NavBar from "@/components/NavBar";
export default {
  name: "App33",
  components: {NavBar, Header}
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