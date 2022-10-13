<template>
  <div class="container">
    <div class="scroll">
      <div :class="['card', { 'selected' : selectedCabin === cabin }]" v-for="cabin in cabins" v-bind:key="cabin.id" @click="selectCabin(cabin)">
        <img :src="cabin.image">
        <p>{{ cabin.type }}</p>
        <p>{{ cabin.location }}</p>
      </div>
    </div>
  </div>
  <button @click="onNewCabin">Add Cabin</button>
  <p v-if="selectedCabin == null">Select a cabin for details</p>
  <router-view v-else v-bind:selected-cabin="selectedCabin" @delete-cabin="deleteSelectedCabin"></router-view>
</template>

<script>
import {Cabin} from "@/models/cabin";
import CabinDetail32 from "@/components/cabins/Detail32";

export default {
  name: "CabinsOverview34",
  components: {
  },
  created() {
    this.lastId = 10000
    for (let i = 0; i < 8; i++) {
      this.cabins.push(
          Cabin.createSampleCabin(this.nextId())
      )
    }
  },
  data(){
    return{
      lastId: 0,
      cabins: [],
      selectedCabin: null,
    }
  },
  methods: {
    nextId(){
      this.lastId = this.lastId + 3
      return this.lastId
    },
    onNewCabin(){
      let newCabin = Cabin.createSampleCabin(this.nextId())
      this.cabins.push(newCabin)
      // this.selectedCabin = newCabin
      this.$router.push("/overview34/"+newCabin.id)
    },
    selectCabin(cabin){
      // if (cabin != null && cabin !== this.selectedCabin){
      //   this.$router.push(this.$route.matched[0].path + "/" + cabin.id)
      // } else if (this.selectedCabin != null){
      //   this.$router.push(this.$route.matched[0].path)
      // }

      if (this.selectedCabin === cabin){
        this.$router.push("/overview34");
      } else {
        this.$router.push("/overview34/"+cabin.id)
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
    }
  },
  watch:{
    '$route'(){
      this.selectedCabin = this.cabins.find(x=>x.id==this.$route.params.cabinId)
    }
  },

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