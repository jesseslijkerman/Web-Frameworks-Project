import {createRouter, createWebHashHistory} from "vue-router";
import Welcome from "@/components/Welcome";
import Overview31 from "@/components/cabins/Overview31";
import Overview32 from "@/components/cabins/Overview32";
import UnknownRoute from "@/components/UnknownRoute";
import Overview33 from "@/components/cabins/Overview33";
import Detail32 from "@/components/cabins/Detail32";
import Detail34 from "@/components/cabins/Detail34";

const routes = [
    {path: '/', component: Welcome},
    {path: '/overview31', component: Overview31},
    {path: '/overview32', component: Overview32},
    {path: '/overview33', component: Overview33, children: [{path: ':cabinId', component: Detail32}]},
    {path: '/overview34', component: Overview33, children: Detail34},
    {path: '/:pathMatch(.*)', component: UnknownRoute}
];

export const router = createRouter({
    history: createWebHashHistory(),
    routes,
    linkActiveClass: "active"
})