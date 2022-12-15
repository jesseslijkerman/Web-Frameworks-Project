<template>
  <div class="container">
    <div class="scroll">
      <div :class="['card', { 'selected' : selectedCabin === cabin }]"
           v-for="cabin in cabins"
           v-bind:key="cabin.id"
           @click="onSelect(cabin)">
        <img :src="cabin.image">
        <p>{{ cabin.type }}</p>
        <p>{{ cabin.location }}</p>
      </div>
    </div>
  </div>
  <button @click="onNewCabin">Add Cabin</button>
  <p v-if="selectedCabin == null">Select a cabin for details</p>
  <router-view v-else @refresh="onReload"></router-view>
</template>

<script>
import {Cabin} from "@/models/cabin";
import CabinDetail32 from "@/components/cabins/Detail32";

export default {
  name: "CabinsOverview37",
  inject: ["cabinsService"],
  async created() {
    await this.onReload();
  },
  data(){
    return{
      lastId: 0,
      cabins: [],
      selectedCabin: null
    }
  },
  methods: {
    onSelect(cabin) {
      // find the parent path by dropping any trailing /NNN from the route path
      let parentPath = this.$route?.fullPath.replace(new RegExp("/\\d*$"),'');
      if (cabin != null && cabin !== this.selectedCabin) {
        // navigate to new child route
        this.$router.push(parentPath + "/" + cabin.id);
        this.selectedCabin = cabin;
      } else {
        // navigate to parent route
        this.$router.push(parentPath);
      }
    },
    async onNewCabin() {
      let newCabin = await this.cabinsService.asyncSave(JSON.stringify(Cabin.createSampleCabin(0)));
      console.log(newCabin)
      this.cabins.push(newCabin)
      this.selectedCabin = newCabin;
      this.$router.push("/overview37/" + newCabin.id)
    },
    selectCabin(cabin){
      if (this.selectedCabin === cabin){
        this.$router.push("/overview37");
      } else {
        this.$router.push("/overview37/"+cabin.id)
      }
    },
    deleteSelectedCabin(cabinId){
      console.log("iets")
      for (let i = 0; i < this.cabins.length; i++) {
        if (this.cabins[i].id === cabinId){
          this.cabins.splice(i, 1)
          this.selectedCabin = null;
        }
      }
    },
    findSelectedFromRouteParam(route){
      console.log(route.params.cabinId)
      let cabinId = route.params.cabinId
      let selectedCabin

      for (let i = 0; i < this.cabins.length; i++) {
        if (this.cabins[i].id === cabinId){
          selectedCabin = this.cabins[i]
        }
      }
      return selectedCabin;
    },
    async onReload(){
      this.cabins = await this.cabinsService.asyncFindAll();
      this.selectedCabin = this.findSelectedFromRouteParam(this.$route?.params?.cabinId)
    }
  },
  watch:{
    '$route'(){
      this.selectedCabin = this.cabins.find(x=>x.id==this.$route.params.cabinId)
    }
  }
}
</script>

<style scoped>
img{
  width: auto;
  height: 100px;
}

.container{
  display: flex;
  justify-content: center;
  margin: auto;
  width: 80%;
}

.scroll {
  display: flex;
  overflow-x: scroll;
}

.card{
  margin-right: 20px;
  padding: 10px;
}

.selected{
  background-color: palegoldenrod;
  color: #6e540a;
  border: 1px solid darkgoldenrod;
}

</style>