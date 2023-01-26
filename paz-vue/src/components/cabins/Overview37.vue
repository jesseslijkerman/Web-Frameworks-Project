<template>
  <div class="container">
    <div class="scroll">
      <div :class="['card', { 'selected' : selectedCabin === cabin }]"
           v-for="cabin in cabins"
           v-bind:key="cabin.id"
           @click="selectCabin(cabin)">
        <img :src="cabin.image">
        <p>{{ cabin.cabinType }}</p>
        <p>{{ cabin.location }}</p>
      </div>
    </div>
  </div>
  <button @click="onNewCabin">Add Cabin</button>
  <p v-show="selectedCabin == null">Select a cabin for details</p>
  <router-view v-show="selectedCabin != null" @refresh="onReload"></router-view>
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
  watch: {
    '$route'() {
      // extracts the selected cabin-id from the route, each time when the route has changed
      this.selectedCabin = this.findSelectedFromRouteParam(this.$route?.params?.id);
    }
  },
  methods: {
    async onNewCabin() {
      console.log(JSON.stringify(Cabin.createSampleCabin(0)))
      console.log(Cabin.createSampleCabin(0))

      let cabin = Cabin.createSampleCabin(0)
      let newCabin = await this.cabinsService.asyncSave(JSON.stringify(cabin));
      this.cabins.push(newCabin)
      this.selectedCabin = newCabin;
      this.$router.push("/overview37/" + newCabin.id)
    },
    selectCabin(cabin){
      if (this.selectedCabin === cabin){
        this.$router.push("/overview37");
        this.selectedCabin = null;
      } else {
        this.selectedCabin = cabin;
        this.$router.push("/overview37/"+cabin.id)
      }
    },
    findSelectedFromRouteParam(route){
      // console.log(route.params.cabinId)
      // let cabinId = route.params.cabinId
      // let selectedCabin
      //
      // for (let i = 0; i < this.cabins.length; i++) {
      //   if (this.cabins[i].id === cabinId){
      //     selectedCabin = this.cabins[i]
      //   }
      // }
      // return selectedCabin;
      console.log("findSelectedFromRouteParam + " + this.$route?.params?.cabinId)
      return this.cabins.find(value => value.id === parseInt(this.$route?.params?.cabinId));

    },
    async onReload(){
      this.cabins = await this.cabinsService.asyncFindAll();
      this.selectedCabin = this.findSelectedFromRouteParam()
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