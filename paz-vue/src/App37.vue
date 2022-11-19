<template>
  <Header></Header>
  <NavBar></NavBar>
  <router-view></router-view>

</template>

<script>
import Header from "@/components/Header";
import NavBar from "@/components/NavBar";
import {CabinsAdaptor} from "@/services/CabinsAdaptor";
// import CONFIG from "../app-config.js" ??
export default {
  name: "App37",
  components: {NavBar, Header},
  provide(){
    return{
      cabinsService: new CabinsAdaptor("http://localhost:8086/cabins")
    }
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