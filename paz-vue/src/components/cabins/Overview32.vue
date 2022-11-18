4<template>
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
  <p v-if="selectedCabin === null">Select a cabin for details</p>
  <CabinDetail32 v-else v-bind:selected-cabin="selectedCabin" @delete-cabin="deleteSelectedCabin"></CabinDetail32>
</template>

<script>
import {Cabin} from "@/models/cabin";
import CabinDetail32 from "@/components/cabins/Detail32";

export default {
  name: "CabinsOverview32",
  components: {
    CabinDetail32
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
      selectedCabin: null
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
      this.selectedCabin = newCabin
    },
    selectCabin(cabin){
      if (this.selectedCabin === cabin){
        this.selectedCabin = null
      } else {
        this.selectedCabin = cabin
      }
    },
    deleteSelectedCabin(cabinId){
      for (let i = 0; i < this.cabins.length; i++) {
        if (this.cabins[i].id === cabinId){
          this.cabins.splice(i, 1)
          this.selectedCabin = null;
        }
      }
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