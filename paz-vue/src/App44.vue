<template>
  <HeaderSb></HeaderSb>
  <NavBarSb></NavBarSb>
  <router-view></router-view>
</template>

<script>
import {SessionSbService} from "@/services/SessionSbService";
import {reactive, shallowReactive} from "vue";
import CONFIG from '../app-config.js'

import NavBar from "@/components/NavBar";
import NavBarSb from "@/components/NavBarSb";
import Header from "@/components/Header";
import {CabinsAdaptor} from "@/services/CabinsAdaptor";
import HeaderSb from "@/components/HeaderSb";

export default {
  name: "App44",
  components: {HeaderSb, NavBarSb},
  provide() {
    //create a singleton reactive service tracking the authorisation data of the session
    this.theSessionSbService = shallowReactive(
        new SessionSbService(CONFIG.BACKEND_URL + "/authentication", CONFIG.JWT_STORAGE_ITEM)
    );
    return{
      // stateless data services adaptor singletons
      cabinsService: new CabinsAdaptor(CONFIG.BACKEND_URL+ "/cabins"),

      // reactive, stateful services
      sessionService: this.theSessionSbService,
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