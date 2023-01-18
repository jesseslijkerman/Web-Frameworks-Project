<template>
  <HeaderSb></HeaderSb>
  <NavBarSb></NavBarSb>
  <router-view></router-view>
</template>

<script>
import {SessionSbService} from "@/services/SessionSbService";
import {reactive, shallowReactive} from "vue";
import CONFIG from '../app-config.js'

import NavBarSb from "@/components/NavBarSb";
import {CabinsAdaptor} from "@/services/CabinsAdaptor";
import HeaderSb from "@/components/HeaderSb";
import {FetchInterceptor} from "@/services/FetchInterceptor";

export default {
  name: "App44",
  components: {HeaderSb, NavBarSb},
  provide() {
    //create a singleton reactive service tracking the authorisation data of the session
    this.theSessionSbService = shallowReactive(
        new SessionSbService(CONFIG.BACKEND_URL + "/authentication", CONFIG.JWT_STORAGE_ITEM))
    this.theFetchInterceptor =
        new FetchInterceptor(this.theSessionSbService, this.$router);
    return{
      // stateless data services adaptor singletons
      cabinsService: new CabinsAdaptor(CONFIG.BACKEND_URL+ "/cabins"),

      // reactive, stateful services
      sessionService: this.theSessionSbService,

      // fetchInterceptor: this.theFetchInterceptor
    }
  },
  unmounted() {
    console.log("App.unmounted() has been called");
    //this.theFetchInterceptor.unregister();
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