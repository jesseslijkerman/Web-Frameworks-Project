<template>
  <Header></Header>
  <NavBar></NavBar>
  <router-view></router-view>
</template>

<script>
import {SessionSbService} from "@/services/SessionSbService";
import {reactive, shallowReactive} from "vue";
import CONFIG from '../app-config.js'

import NavBar from "@/components/NavBar";
import Header from "@/components/Header";
import {CabinsAdaptor} from "@/services/CabinsAdaptor";

export default {
  name: "App44",
  components: {NavBar, Header},
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

<style scoped>

</style>