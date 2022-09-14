<template>
  <Header></Header>
  <NavBar></NavBar>
  <Welcome></Welcome>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'
import Welcome from "@/components/Welcome";
import Header from "@/components/Header";
import NavBar from "@/components/NavBar";


export default {
  name: 'App',
  components: {
    Header,
    NavBar,
    Welcome
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
</style>
