package com.zackyzhang.mymvpdemo.data.entity.Movie;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lei on 2/8/17.
 */

public class MovieEntity {

    /**
     * adult : false
     * backdrop_path : /xu9zaAevzQ5nnrsXN6JcahLnG4i.jpg
     * belongs_to_collection : null
     * budget : 165000000
     * genres : [{"id":12,"name":"Adventure"},{"id":18,"name":"Drama"},{"id":878,"name":"Science Fiction"}]
     * homepage : http://www.interstellarmovie.net/
     * id : 157336
     * imdb_id : tt0816692
     * original_language : en
     * original_title : Interstellar
     * overview : Interstellar chronicles the adventures of a group of explorers who make use of a newly discovered wormhole to surpass the limitations on human space travel and conquer the vast distances involved in an interstellar voyage.
     * popularity : 40.750524
     * poster_path : /nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg
     * production_companies : [{"name":"Paramount Pictures","id":4},{"name":"Legendary Pictures","id":923},{"name":"Warner Bros.","id":6194},{"name":"Syncopy","id":9996},{"name":"Lynda Obst Productions","id":13769}]
     * production_countries : [{"iso_3166_1":"CA","name":"Canada"},{"iso_3166_1":"US","name":"United States of America"},{"iso_3166_1":"GB","name":"United Kingdom"}]
     * release_date : 2014-11-05
     * revenue : 621752480
     * runtime : 169
     * spoken_languages : [{"iso_639_1":"en","name":"English"}]
     * status : Released
     * tagline : Mankind was born on Earth. It was never meant to die here.
     * title : Interstellar
     * video : false
     * vote_average : 8
     * vote_count : 6931
     * videos : {"results":[{"id":"5795006f92514142390035ae","iso_639_1":"en","iso_3166_1":"US","key":"Rt2LHkSwdPQ","name":"Official Trailer #2","site":"YouTube","size":1080,"type":"Trailer"},{"id":"57817accc3a368592500392e","iso_639_1":"en","iso_3166_1":"US","key":"0vxOhd4qlnA","name":"Official Trailer #3","site":"YouTube","size":1080,"type":"Trailer"},{"id":"57817ada9251417c28000b02","iso_639_1":"en","iso_3166_1":"US","key":"827FNDpQWrQ","name":"Official UK Teaser Trailer","site":"YouTube","size":1080,"type":"Trailer"},{"id":"57817a91c3a36873ea000adf","iso_639_1":"en","iso_3166_1":"US","key":"nyc6RJEEe0U","name":"Official Teaser","site":"YouTube","size":1080,"type":"Teaser"},{"id":"57817aa69251417bfc000a58","iso_639_1":"en","iso_3166_1":"US","key":"zSWdZVtXT7E","name":"Official UK Trailer","site":"YouTube","size":1080,"type":"Trailer"},{"id":"57817ab4c3a36813870024b7","iso_639_1":"en","iso_3166_1":"US","key":"KlyknsTJk0w","name":"Own it today","site":"YouTube","size":1080,"type":"Teaser"},{"id":"5794fffbc3a36829ab00056f","iso_639_1":"en","iso_3166_1":"US","key":"2LqzF5WauAw","name":"Official Trailer","site":"YouTube","size":1080,"type":"Trailer"},{"id":"57817b0fc3a368592500394d","iso_639_1":"en","iso_3166_1":"US","key":"LY19rHKAaAg","name":"Official UK Trailer 4","site":"YouTube","size":1080,"type":"Trailer"},{"id":"57817b1a9251417b8e000a8c","iso_639_1":"en","iso_3166_1":"US","key":"ePbKGoIGAXY","name":"Official UK Trailer #3","site":"YouTube","size":1080,"type":"Trailer"}]}
     * images : {"backdrops":[{"aspect_ratio":1.77777777777778,"file_path":"/xu9zaAevzQ5nnrsXN6JcahLnG4i.jpg","height":1080,"iso_639_1":null,"vote_average":5.55555555555556,"vote_count":15,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/gq4Z1pfOWHn3FKFNutlDCySps9C.jpg","height":1080,"iso_639_1":"xx","vote_average":5.46296296296296,"vote_count":9,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/vFJ31Mp68hwtlB4opsAP29gFqhr.jpg","height":1080,"iso_639_1":null,"vote_average":5.40117416829746,"vote_count":10,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/y4ODodoKWWm7KODB6WgPDHv6Bzd.jpg","height":1080,"iso_639_1":null,"vote_average":5.38461538461539,"vote_count":2,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/sn8LEtCXquQJYEVygbW8YUfumwW.jpg","height":1080,"iso_639_1":null,"vote_average":5.38461538461539,"vote_count":2,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/o4BjoraqJLfuRZBhiFXSgRZDUyu.jpg","height":1080,"iso_639_1":null,"vote_average":5.37518037518038,"vote_count":3,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/xW3MLq7t8gynEiFj3E4YP7KQoqw.jpg","height":1080,"iso_639_1":null,"vote_average":5.36796536796537,"vote_count":3,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/6MDzVm9h6wEGAbvjihdFU83Q5Wo.jpg","height":1080,"iso_639_1":null,"vote_average":5.34065934065934,"vote_count":2,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/3mPXGfKcsYIEhl4et2WTSX0llVh.jpg","height":1080,"iso_639_1":"en","vote_average":5.32091097308489,"vote_count":6,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/tAkBC4X2Rp3QtV7rzqTv8DU3fTA.jpg","height":1080,"iso_639_1":null,"vote_average":5.3125,"vote_count":1,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/walWq52PP2IGRc98VkPG7Wp77lK.jpg","height":1080,"iso_639_1":null,"vote_average":5.312,"vote_count":1,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/tn9JffYteR9LSGWx2FC8T1uO403.jpg","height":1080,"iso_639_1":null,"vote_average":5.30505952380952,"vote_count":1,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/5cgKuGbnGPzh5YRZcqK8kZGnjl7.jpg","height":1080,"iso_639_1":null,"vote_average":5.29761904761905,"vote_count":1,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/nYtBxRwoQTfzSDmAB3l7TIdPLpY.jpg","height":1080,"iso_639_1":null,"vote_average":5.29017857142857,"vote_count":1,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/bbyI73zXfC8cxkT8xCimyttZrRA.jpg","height":1080,"iso_639_1":null,"vote_average":5.28273809523809,"vote_count":1,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/rN9Vjna7lnS9jcrSMNvYQEWCRlK.jpg","height":1080,"iso_639_1":null,"vote_average":5.28273809523809,"vote_count":1,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/s4fd4EfqBFYMbZmIdhNdCLwFrhO.jpg","height":1080,"iso_639_1":null,"vote_average":5.28205128205128,"vote_count":2,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/aivK6Z2naJsHz5EJFweLP2G7hS.jpg","height":1080,"iso_639_1":"xx","vote_average":5.23809523809524,"vote_count":2,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/oAmkQmTUZ8bkyVbch56TrKHzmuu.jpg","height":1152,"iso_639_1":null,"vote_average":5.23809523809524,"vote_count":4,"width":2048},{"aspect_ratio":1.77777777777778,"file_path":"/8CQeAuMbR7pFlvZlgV7Oac3ZbDH.jpg","height":1080,"iso_639_1":null,"vote_average":5.23065476190476,"vote_count":1,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/cwcibDD8VeZ34SNWTJazEeBho1s.jpg","height":1080,"iso_639_1":"en","vote_average":5.17857142857143,"vote_count":1,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/9Bnh8RkPpPoo3ftLyDrDPDTMK8p.jpg","height":1152,"iso_639_1":null,"vote_average":5.16594516594517,"vote_count":3,"width":2048},{"aspect_ratio":1.77777777777778,"file_path":"/gvldej73NLKaC4j7sCldj1sTjjD.jpg","height":1080,"iso_639_1":"en","vote_average":5.14285714285714,"vote_count":2,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/5EV88Qt5oDRbnj9F9osFrg3Yd55.jpg","height":1080,"iso_639_1":null,"vote_average":5.134,"vote_count":5,"width":1920},{"aspect_ratio":1.7752808988764,"file_path":"/bUSsMnf8K9wug5aJ8P6jpZT25MV.jpg","height":801,"iso_639_1":null,"vote_average":5.10504201680672,"vote_count":5,"width":1422},{"aspect_ratio":1.77777777777778,"file_path":"/fAAwITtgyzwEy6YstNPxnQ00d6z.jpg","height":1152,"iso_639_1":null,"vote_average":5.07936507936508,"vote_count":3,"width":2048},{"aspect_ratio":1.77777777777778,"file_path":"/zX1SB9uuQaJJw2kjZszNHx5PqwI.jpg","height":2160,"iso_639_1":"en","vote_average":0,"vote_count":0,"width":3840},{"aspect_ratio":1.77777777777778,"file_path":"/zWyDer0uZdwFnOfthdJvy4qykZm.jpg","height":1080,"iso_639_1":null,"vote_average":0,"vote_count":0,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/pwRzDssAENT121YkSvfR2uSEfh7.jpg","height":1080,"iso_639_1":null,"vote_average":0,"vote_count":0,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/b3htE2IM0XvupfVg8IKfb2KcKzw.jpg","height":1080,"iso_639_1":null,"vote_average":0,"vote_count":0,"width":1920}],"posters":[{"aspect_ratio":0.6668,"file_path":"/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg","height":2500,"iso_639_1":"en","vote_average":5.94,"vote_count":51,"width":1667},{"aspect_ratio":0.666666666666667,"file_path":"/m0UDkSPoVkmNfXFR9FN13yewy4B.jpg","height":3000,"iso_639_1":"en","vote_average":5.538,"vote_count":40,"width":2000},{"aspect_ratio":0.6748046875,"file_path":"/cUKn61e7bUUglIGNGBEtzyuCDR4.jpg","height":2048,"iso_639_1":"it","vote_average":5.44733044733045,"vote_count":3,"width":1382},{"aspect_ratio":0.666666666666667,"file_path":"/qAr3kvQeKu1UMOOrt50kUqEkdlr.jpg","height":1500,"iso_639_1":"fr","vote_average":5.446,"vote_count":15,"width":1000},{"aspect_ratio":0.666666666666667,"file_path":"/5FAPDK7EAB7fx1Yj45jvWoQzHBr.jpg","height":1500,"iso_639_1":"en","vote_average":5.422,"vote_count":7,"width":1000},{"aspect_ratio":0.666666666666667,"file_path":"/7CBRDBy1SvKFUIRarHQTIUmD4cM.jpg","height":2100,"iso_639_1":"fr","vote_average":5.392,"vote_count":8,"width":1400},{"aspect_ratio":0.666666666666667,"file_path":"/87oMFHZmSDkVm8P2i33yy3AJcsv.jpg","height":1080,"iso_639_1":"ru","vote_average":5.38461538461539,"vote_count":2,"width":720},{"aspect_ratio":0.666666666666667,"file_path":"/bNwCcAvCRguxXqSjPgSr6mgrX0A.jpg","height":3000,"iso_639_1":"ru","vote_average":5.38461538461539,"vote_count":2,"width":2000},{"aspect_ratio":0.700985761226725,"file_path":"/hxGAYQDrvOH1kTlCGKlP0NE4Gar.jpg","height":1826,"iso_639_1":"zh","vote_average":5.384,"vote_count":2,"width":1280},{"aspect_ratio":0.666666666666667,"file_path":"/mJduNZNy9asMKoQBn0MbBmdpwvN.jpg","height":2100,"iso_639_1":"en","vote_average":5.36967418546366,"vote_count":13,"width":1400},{"aspect_ratio":0.699708454810496,"file_path":"/7C0oiPn46OvaMxET9iq1f5BsyMS.jpg","height":1715,"iso_639_1":"es","vote_average":5.348,"vote_count":2,"width":1200},{"aspect_ratio":0.700218818380744,"file_path":"/un9rcF1SaU1FyMcNwMheSEGEhXA.jpg","height":914,"iso_639_1":"zh","vote_average":5.318,"vote_count":3,"width":640},{"aspect_ratio":0.666666666666667,"file_path":"/o2eH7rg6XlWLkyjNVAIxQcWkQzi.jpg","height":1500,"iso_639_1":"pt","vote_average":5.31746031746032,"vote_count":3,"width":1000},{"aspect_ratio":0.666666666666667,"file_path":"/ceObcMuQxtX9HJ4VaJvLg6WuhIf.jpg","height":2700,"iso_639_1":"de","vote_average":5.31746031746032,"vote_count":3,"width":1800},{"aspect_ratio":0.693140794223827,"file_path":"/cZjfsOFVCu2aKBPdjoAUqebVdoo.jpg","height":1108,"iso_639_1":"el","vote_average":5.3125,"vote_count":1,"width":768},{"aspect_ratio":0.666666666666667,"file_path":"/99bOV4iEoltarXMtgM5FBQcSapG.jpg","height":3000,"iso_639_1":null,"vote_average":5.3125,"vote_count":1,"width":2000},{"aspect_ratio":0.666666666666667,"file_path":"/8lQXRsFthb8lUUw0LJNgLcSLdlD.jpg","height":1500,"iso_639_1":"hu","vote_average":5.3125,"vote_count":1,"width":1000},{"aspect_ratio":0.700176366843034,"file_path":"/aDyHU4eKruHVxqo2PKI0AhXIysD.jpg","height":2835,"iso_639_1":"ro","vote_average":5.3125,"vote_count":1,"width":1985},{"aspect_ratio":0.70048097944906,"file_path":"/zephyR9sWnscPjadlDhWXPWosmV.jpg","height":2287,"iso_639_1":"ko","vote_average":5.3125,"vote_count":1,"width":1602},{"aspect_ratio":0.6668,"file_path":"/aBONu8Boj7t5sdPR4ul69tfKs2q.jpg","height":2500,"iso_639_1":"ru","vote_average":5.3125,"vote_count":1,"width":1667},{"aspect_ratio":0.6668,"file_path":"/5IGqQ86P8dfpNShocqz8rx38mv0.jpg","height":2500,"iso_639_1":"ru","vote_average":5.3125,"vote_count":1,"width":1667},{"aspect_ratio":0.699912510936133,"file_path":"/t9HT1HX2YTHeZ62IgyGQwxBv5VW.jpg","height":1143,"iso_639_1":"uk","vote_average":5.3125,"vote_count":1,"width":800},{"aspect_ratio":0.685546875,"file_path":"/jUnawJbbuKmQtJD1o3B7Bh44b0h.jpg","height":2048,"iso_639_1":"it","vote_average":5.3125,"vote_count":1,"width":1404},{"aspect_ratio":0.666666666666667,"file_path":"/vJ0vKTdVMr3a6u0PlOTjwk74WnG.jpg","height":2100,"iso_639_1":"en","vote_average":5.312,"vote_count":8,"width":1400},{"aspect_ratio":0.674915635545557,"file_path":"/x0Y4lhF2eTOVfhStOlpBEKU49RS.jpg","height":1778,"iso_639_1":"es","vote_average":5.312,"vote_count":2,"width":1200},{"aspect_ratio":0.666666666666667,"file_path":"/5SyskAKbinj9SGuo9bPq4sH4tbl.jpg","height":1500,"iso_639_1":"hu","vote_average":5.3040293040293,"vote_count":2,"width":1000},{"aspect_ratio":0.701117318435754,"file_path":"/h54I7hdRtB1a3370t0gd4nwPBGO.jpg","height":1074,"iso_639_1":"pt","vote_average":5.29761904761905,"vote_count":1,"width":753},{"aspect_ratio":0.666666666666667,"file_path":"/lbGGuk9K1kNQqDabaMyFz1L9iTg.jpg","height":3000,"iso_639_1":"en","vote_average":5.28467908902691,"vote_count":29,"width":2000},{"aspect_ratio":0.666666666666667,"file_path":"/smbZEQIpWRA3zLxWg4Q9HiAXq4s.jpg","height":2700,"iso_639_1":"de","vote_average":5.28011204481793,"vote_count":5,"width":1800},{"aspect_ratio":0.675105485232067,"file_path":"/trnlYCazvHA5ig6BtUTksX40MYb.jpg","height":1185,"iso_639_1":"hu","vote_average":5.26041666666667,"vote_count":1,"width":800},{"aspect_ratio":0.666666666666667,"file_path":"/6n1BJ66UYNHhk3kA8lSIRjSRFLu.jpg","height":2700,"iso_639_1":"en","vote_average":5.25274725274725,"vote_count":2,"width":1800},{"aspect_ratio":0.666666666666667,"file_path":"/7k55id8PshlNb2bHcdhIJ2xnC7H.jpg","height":1500,"iso_639_1":"fr","vote_average":5.246,"vote_count":2,"width":1000},{"aspect_ratio":0.707142857142857,"file_path":"/9yVkGkopgE2Ja0GBhbKsYpPn6Z9.jpg","height":1400,"iso_639_1":"de","vote_average":5.24542124542125,"vote_count":2,"width":990},{"aspect_ratio":0.683,"file_path":"/Ac2BkXArHtoZtyTUK1Ss7lKY0On.jpg","height":1000,"iso_639_1":"ru","vote_average":5.24542124542125,"vote_count":2,"width":683},{"aspect_ratio":0.666666666666667,"file_path":"/yUPgXs3X0R97GPcCokAUBUlAAcF.jpg","height":2700,"iso_639_1":"de","vote_average":5.24542124542125,"vote_count":2,"width":1800},{"aspect_ratio":0.666666666666667,"file_path":"/nq2X2VIFoBEaEirTAsbVqI5oJhU.jpg","height":2700,"iso_639_1":"de","vote_average":5.24542124542125,"vote_count":2,"width":1800},{"aspect_ratio":0.666666666666667,"file_path":"/ddp5TCWAhu0jc14iqid3jqN5vXq.jpg","height":2700,"iso_639_1":"de","vote_average":5.24542124542125,"vote_count":2,"width":1800},{"aspect_ratio":0.7125,"file_path":"/vYXMsN78Mc5sr5Y067xkzxb2T16.jpg","height":800,"iso_639_1":"da","vote_average":5.23809523809524,"vote_count":1,"width":570},{"aspect_ratio":0.693512304250559,"file_path":"/8hzAPcLHM246bPSBirgagYoKAPs.jpg","height":894,"iso_639_1":"hu","vote_average":5.23809523809524,"vote_count":1,"width":620},{"aspect_ratio":0.6668,"file_path":"/gthKURgD9wBq0NDniY8TI5wtKE1.jpg","height":2500,"iso_639_1":"en","vote_average":5.23809523809524,"vote_count":23,"width":1667},{"aspect_ratio":0.666666666666667,"file_path":"/42yAYissryXg63liRM3tRtw5lJj.jpg","height":2100,"iso_639_1":"fr","vote_average":5.238,"vote_count":5,"width":1400},{"aspect_ratio":0.666666666666667,"file_path":"/giOHpscElE74zONUsWvSjjkGA8E.jpg","height":900,"iso_639_1":"en","vote_average":5.21645021645022,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/oJ4NCfmVXTMOkCUt5TA8V3HvOt3.jpg","height":900,"iso_639_1":"en","vote_average":5.21645021645022,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/wiqjcGodHbZEUGbeCPCYgOdZBSz.jpg","height":900,"iso_639_1":"en","vote_average":5.21645021645022,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/wjjQEyP7ECzhWNSIlwJc2ibMFeS.jpg","height":900,"iso_639_1":"en","vote_average":5.21645021645022,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/lMosVVdg1o5voKALa6c2T98eYY.jpg","height":900,"iso_639_1":"en","vote_average":5.21645021645022,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/ixcQaGli7AiIHdMsIaTkNHNtp1.jpg","height":900,"iso_639_1":"en","vote_average":5.21645021645022,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/iRWiqrt6aw8lcs2PqjIoekvOULE.jpg","height":900,"iso_639_1":"en","vote_average":5.21645021645022,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/qyYejCBslbqMEFRzxsRASRc5Qx6.jpg","height":2100,"iso_639_1":"en","vote_average":5.21645021645022,"vote_count":3,"width":1400},{"aspect_ratio":0.666666666666667,"file_path":"/k3wi2UjET0V3GSwuQuAsmapbThT.jpg","height":900,"iso_639_1":"en","vote_average":5.20923520923521,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/6ftoOE4J1icc54ojCvCcvcdCQ6e.jpg","height":900,"iso_639_1":"en","vote_average":5.20923520923521,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/zJUz3rRChbMvISPpzjK13ovQIEr.jpg","height":900,"iso_639_1":"en","vote_average":5.2020202020202,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/33kQqVUB2TcI7HoMhaQ4qNjLquL.jpg","height":900,"iso_639_1":"en","vote_average":5.2020202020202,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/gbwfT3lguOWZRLft3gEwWR6M9ke.jpg","height":900,"iso_639_1":"en","vote_average":5.2020202020202,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/Aik3rm4drM9ePSxAVejYVLAmoDX.jpg","height":900,"iso_639_1":"en","vote_average":5.2020202020202,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/7dLE2CUnpBPCMo632uYQRAmrXUr.jpg","height":900,"iso_639_1":"en","vote_average":5.2020202020202,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/sI0JVp3918D9RMm6XFRBAd7qkJy.jpg","height":3000,"iso_639_1":null,"vote_average":5.2014652014652,"vote_count":2,"width":2000},{"aspect_ratio":0.75,"file_path":"/d5sWu7rkZBadUabqnfey2LDhqn7.jpg","height":1600,"iso_639_1":"fr","vote_average":5.19727891156463,"vote_count":7,"width":1200},{"aspect_ratio":0.666666666666667,"file_path":"/1qhxlL8L2V7zGzHs32yDIz89rFx.jpg","height":750,"iso_639_1":"fr","vote_average":5.19607843137255,"vote_count":5,"width":500},{"aspect_ratio":0.666666666666667,"file_path":"/i9Vf5kccuC7ugrHNQbJCYrRfuff.jpg","height":900,"iso_639_1":"en","vote_average":5.19480519480519,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/kyR7aKIXa0jjeacAMSeizAzMQ06.jpg","height":900,"iso_639_1":"en","vote_average":5.19480519480519,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/n8K3ErdQNXVmaaVX6oEU7y1Qbi2.jpg","height":900,"iso_639_1":"en","vote_average":5.19480519480519,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/k5PApdAswEbUX6ZA6arSy5d97bn.jpg","height":900,"iso_639_1":"en","vote_average":5.18759018759019,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/m8XK4N3oWczjaeVw5Q9h8aQYnrn.jpg","height":900,"iso_639_1":"en","vote_average":5.18759018759019,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/qk2y2o8LltLE5IfMqBMzKlWXjX9.jpg","height":900,"iso_639_1":"en","vote_average":5.18759018759019,"vote_count":3,"width":600},{"aspect_ratio":0.675105485232067,"file_path":"/dTL7B5JQgkgXd2cZTaUQgrL4f1q.jpg","height":2370,"iso_639_1":"en","vote_average":5.18730158730159,"vote_count":12,"width":1600},{"aspect_ratio":0.666666666666667,"file_path":"/icYFvVVvStxR8ZM0ekeWHFloEAB.jpg","height":900,"iso_639_1":"en","vote_average":5.18123667377399,"vote_count":4,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/30NKpAX7Y3n64u5funrynxe5z6Z.jpg","height":900,"iso_639_1":"en","vote_average":5.18037518037518,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/hLg3fhDny3k2IJyV7sjBPrML3f7.jpg","height":900,"iso_639_1":"en","vote_average":5.18037518037518,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/xG8xcns3LuXZbipfRxzdSsBMzqf.jpg","height":900,"iso_639_1":"en","vote_average":5.18037518037518,"vote_count":3,"width":600},{"aspect_ratio":0.711511789181692,"file_path":"/hNoHqD8Leg2MZG0V38ZwTxs9W42.jpg","height":2163,"iso_639_1":"fr","vote_average":5.18037518037518,"vote_count":3,"width":1539},{"aspect_ratio":0.666666666666667,"file_path":"/xT3EkyLG3ORvXcldLq4y1cirh6F.jpg","height":2700,"iso_639_1":"de","vote_average":5.18037518037518,"vote_count":3,"width":1800},{"aspect_ratio":0.666666666666667,"file_path":"/h9g0VzJzi7xqQXjXzmY4ZcKNC2M.jpg","height":2700,"iso_639_1":"de","vote_average":5.18037518037518,"vote_count":3,"width":1800},{"aspect_ratio":0.666666666666667,"file_path":"/vfc8KP6bhJt9USHMyoZ8BnDRRqo.jpg","height":3000,"iso_639_1":"zh","vote_average":5.18,"vote_count":3,"width":2000},{"aspect_ratio":0.666666666666667,"file_path":"/fMlSFgIB4Kr7YmuqNLHEWN2dkBG.jpg","height":3000,"iso_639_1":"zh","vote_average":5.18,"vote_count":3,"width":2000},{"aspect_ratio":0.666666666666667,"file_path":"/mPRSdQXqg5hC3RGsyJUv8DGtl6a.jpg","height":3000,"iso_639_1":null,"vote_average":5.17948717948718,"vote_count":2,"width":2000},{"aspect_ratio":0.666666666666667,"file_path":"/mfAEs1RerVX3yAwOPJQGt4V2CGH.jpg","height":900,"iso_639_1":"en","vote_average":5.17316017316017,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/6cHRn5pV8xJ9Z5oaq4N8iyAtgKL.jpg","height":900,"iso_639_1":"en","vote_average":5.17316017316017,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/dnMaeDrUdGnYC2mcdSnnlUJrsC4.jpg","height":900,"iso_639_1":"en","vote_average":5.17316017316017,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/vBRwC2nl5ikdOHcg3KFw5BayW1K.jpg","height":900,"iso_639_1":"en","vote_average":5.17316017316017,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/8hHdtEVqy5r849JzV21vj8bkhRu.jpg","height":900,"iso_639_1":"en","vote_average":5.17316017316017,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/zZt8MZHVvI3KgyHG5XhtkKThfMy.jpg","height":900,"iso_639_1":"en","vote_average":5.17316017316017,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/Ah7WLTmjqJ3ZMLYzrwmi2x6DAUo.jpg","height":900,"iso_639_1":"en","vote_average":5.17316017316017,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/qhmTUgpzPJOFNe5jXBIxy2xmbqI.jpg","height":2400,"iso_639_1":"en","vote_average":5.17316017316017,"vote_count":3,"width":1600},{"aspect_ratio":0.666666666666667,"file_path":"/A5Y3sptCzxWS16ViyKjb3sahlbs.jpg","height":3000,"iso_639_1":null,"vote_average":5.17216117216117,"vote_count":2,"width":2000},{"aspect_ratio":0.694375,"file_path":"/otoibWOTaDn1iofyLAECNb1ZYxJ.jpg","height":1600,"iso_639_1":"es","vote_average":5.172,"vote_count":1,"width":1111},{"aspect_ratio":0.666666666666667,"file_path":"/hclHtzLwJYWCvpJpcfNB4geUkJl.jpg","height":3000,"iso_639_1":"en","vote_average":5.16908212560386,"vote_count":6,"width":2000},{"aspect_ratio":0.666666666666667,"file_path":"/zyfEGaZXWX6I3Zwccy09zWW8RGL.jpg","height":900,"iso_639_1":"en","vote_average":5.16594516594517,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/aaXziItQKEQ4p5AF0N0TCSkcCaM.jpg","height":900,"iso_639_1":"en","vote_average":5.16594516594517,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/zVW7i4XPw7igc0IzFwC7OCsDhN7.jpg","height":900,"iso_639_1":"en","vote_average":5.16594516594517,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/2zqD8d9gMIegmMTSOZ3AVWdsEz7.jpg","height":900,"iso_639_1":"en","vote_average":5.16594516594517,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/3EWgOYwalktAinA3wdiH1MaT8eH.jpg","height":900,"iso_639_1":"en","vote_average":5.16594516594517,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/QXt1iyNG8ALFs6xOIOh1HVtMJC.jpg","height":900,"iso_639_1":"en","vote_average":5.16594516594517,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/zR4SvO2Nx61Yuoxt5JJUEg8XVOf.jpg","height":900,"iso_639_1":"en","vote_average":5.16594516594517,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/33MhreHmi3CXBVg38OUYaO975aF.jpg","height":900,"iso_639_1":"en","vote_average":5.16594516594517,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/8EA3isezthVMGiYJ5Fs3VyRtgEn.jpg","height":900,"iso_639_1":"en","vote_average":5.16594516594517,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/7ZgF4E0rGz9S25nsgOqlR4q5rUh.jpg","height":900,"iso_639_1":"en","vote_average":5.15873015873016,"vote_count":3,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/qQ02znOZYNqzCwyg3gKd9Uq1jUB.jpg","height":900,"iso_639_1":"en","vote_average":5.15151515151515,"vote_count":3,"width":600},{"aspect_ratio":0.73586118251928,"file_path":"/imvW7LZc4vxeQBHLWgNbrlcNY3M.jpg","height":1556,"iso_639_1":"fr","vote_average":5.13749161636486,"vote_count":8,"width":1145},{"aspect_ratio":0.674556213017751,"file_path":"/mOME1hPH3MhpME7JpP9rym9XCBw.jpg","height":845,"iso_639_1":"fr","vote_average":5.12767425810904,"vote_count":6,"width":570},{"aspect_ratio":0.674749604638904,"file_path":"/w1dJ9BhRDMizcGFfATkMbdpOtv9.jpg","height":1897,"iso_639_1":"en","vote_average":5.12605042016807,"vote_count":5,"width":1280},{"aspect_ratio":0.666666666666667,"file_path":"/5xGVqIUuT62Mn7KG3tB8TUw2dJV.jpg","height":3000,"iso_639_1":"en","vote_average":5.11761331038439,"vote_count":20,"width":2000},{"aspect_ratio":0.666666666666667,"file_path":"/qFx2gtadhddh1YDuKO0hsUbk29d.jpg","height":2100,"iso_639_1":"fr","vote_average":5.11727078891258,"vote_count":4,"width":1400},{"aspect_ratio":0.666666666666667,"file_path":"/e1JozgstLfPnhKJ6y72S3QxeJmy.jpg","height":3000,"iso_639_1":"zh","vote_average":5.106,"vote_count":2,"width":2000},{"aspect_ratio":0.666666666666667,"file_path":"/fptFahOwB4vrP0e4AsMPgw8ICo3.jpg","height":3000,"iso_639_1":"zh","vote_average":5.106,"vote_count":2,"width":2000},{"aspect_ratio":0.640030154542028,"file_path":"/2ZRnVnXHZ3gEeNlZqQO1jsogxhY.jpg","height":2653,"iso_639_1":"en","vote_average":5.09291521486643,"vote_count":19,"width":1698},{"aspect_ratio":0.666666666666667,"file_path":"/cgQQDY6xbiWUXjXXAJDOA5Xkfyr.jpg","height":1500,"iso_639_1":"en","vote_average":5.02164502164502,"vote_count":14,"width":1000},{"aspect_ratio":0.666666666666667,"file_path":"/kOvq6XEWE3jET3wWohJnTQvvm0b.jpg","height":3000,"iso_639_1":"en","vote_average":5.01725327812284,"vote_count":6,"width":2000},{"aspect_ratio":0.666429587482219,"file_path":"/5cePxRqJ3LUBnYcXEMQhBmx2Wpj.jpg","height":1406,"iso_639_1":"en","vote_average":5.0167672702884,"vote_count":8,"width":937},{"aspect_ratio":0.675024108003857,"file_path":"/cT9h8G4j06TZ7RYkK3sS9jRxOpv.jpg","height":1037,"iso_639_1":"en","vote_average":4.98712998712999,"vote_count":11,"width":700},{"aspect_ratio":0.666666666666667,"file_path":"/62ghIyRLyS89r7nGlwbXfuZUJio.jpg","height":1050,"iso_639_1":"en","vote_average":4.85714285714286,"vote_count":7,"width":700},{"aspect_ratio":0.680272108843537,"file_path":"/vV2rDBhnrEpmNGcsP6uwCfZv8oY.jpg","height":1764,"iso_639_1":"en","vote_average":4.73544973544974,"vote_count":9,"width":1200},{"aspect_ratio":0.702576112412178,"file_path":"/pMMXJh6trNYE9Xejf7guzRV6ZhP.jpg","height":854,"iso_639_1":"es","vote_average":0,"vote_count":0,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/2ohX5apxgqUw8lTdCEc21zozQI9.jpg","height":2250,"iso_639_1":"es","vote_average":0,"vote_count":0,"width":1500},{"aspect_ratio":0.666666666666667,"file_path":"/lWfvYb5dF7TBc6GNx6ucooeeKy2.jpg","height":960,"iso_639_1":"en","vote_average":0,"vote_count":0,"width":640},{"aspect_ratio":0.700381679389313,"file_path":"/tHDMY2FvJRnDfAo7aDd953TByYj.jpg","height":1048,"iso_639_1":"ko","vote_average":0,"vote_count":0,"width":734},{"aspect_ratio":0.700381679389313,"file_path":"/gGTICmnUBTSuaGuiue2zt5Zl4Bj.jpg","height":1048,"iso_639_1":"ko","vote_average":0,"vote_count":0,"width":734},{"aspect_ratio":0.700381679389313,"file_path":"/xQ9iYQMd9UmbPFaTHrM3SHEAQ9A.jpg","height":1048,"iso_639_1":"ko","vote_average":0,"vote_count":0,"width":734},{"aspect_ratio":0.700381679389313,"file_path":"/7a4uxYpYLCw0s0mbkt3IIv0PZho.jpg","height":1048,"iso_639_1":"ko","vote_average":0,"vote_count":0,"width":734},{"aspect_ratio":0.687049124012367,"file_path":"/8JWBqdo8BEft1b1Y6K0pAr6Xmx5.jpg","height":2911,"iso_639_1":"it","vote_average":0,"vote_count":0,"width":2000},{"aspect_ratio":0.699576868829337,"file_path":"/lR07w5b4nDHQeVX6WAMNfUbUmvt.jpg","height":1418,"iso_639_1":"tr","vote_average":0,"vote_count":0,"width":992},{"aspect_ratio":0.692182410423453,"file_path":"/54AseTG5iudeXvJGND6cxmtNUkz.jpg","height":1228,"iso_639_1":"bg","vote_average":0,"vote_count":0,"width":850},{"aspect_ratio":0.694063926940639,"file_path":"/rH3D3Kwg8R5woZj1YnJwU6WHYdo.jpg","height":1095,"iso_639_1":"he","vote_average":0,"vote_count":0,"width":760},{"aspect_ratio":0.685546875,"file_path":"/ufNy2biWKMflOoMZEllfPEewYcv.jpg","height":2048,"iso_639_1":"it","vote_average":0,"vote_count":0,"width":1404},{"aspect_ratio":0.678708264915161,"file_path":"/tC0SpMCyy5TKQjXSY6PDkGVcPlo.jpg","height":1827,"iso_639_1":"ar","vote_average":0,"vote_count":0,"width":1240},{"aspect_ratio":0.7,"file_path":"/zZeD25PtS0zHPgUWMLuUnuxk4W6.jpg","height":1200,"iso_639_1":"it","vote_average":0,"vote_count":0,"width":840},{"aspect_ratio":0.705146036161335,"file_path":"/cAlsFsxtQhZmERoxYmsMKxntEkt.jpg","height":2157,"iso_639_1":"hu","vote_average":0,"vote_count":0,"width":1521},{"aspect_ratio":0.700035001750087,"file_path":"/fI8Q1ImGYbd5cdeOoXBV9Xcy6ud.jpg","height":2857,"iso_639_1":"it","vote_average":0,"vote_count":0,"width":2000}]}
     */

    @SerializedName("adult")
    private boolean adult;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("belongs_to_collection")
    private Object belongsToCollection;
    @SerializedName("budget")
    private int budget;
    @SerializedName("homepage")
    private String homepage;
    @SerializedName("id")
    private int id;
    @SerializedName("imdb_id")
    private String imdbId;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("overview")
    private String overview;
    @SerializedName("popularity")
    private double popularity;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("revenue")
    private int revenue;
    @SerializedName("runtime")
    private int runtime;
    @SerializedName("status")
    private String status;
    @SerializedName("tagline")
    private String tagline;
    @SerializedName("title")
    private String title;
    @SerializedName("video")
    private boolean video;
    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("vote_count")
    private int voteCount;
    @SerializedName("videos")
    private MovieVideos videos;
    @SerializedName("images")
    private MovieImages images;
    @SerializedName("genres")
    private List<MovieGenre> genres;
    @SerializedName("production_companies")
    private List<MovieProductionCompany> productionCompanies;
    @SerializedName("production_countries")
    private List<MovieProductionCountry> productionCountries;
    @SerializedName("spoken_languages")
    private List<MovieSpokenLanguage> spokenLanguages;

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Object getBelongsToCollection() {
        return belongsToCollection;
    }

    public void setBelongsToCollection(Object belongsToCollection) {
        this.belongsToCollection = belongsToCollection;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(int voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public MovieVideos getVideos() {
        return videos;
    }

    public void setVideos(MovieVideos videos) {
        this.videos = videos;
    }

    public MovieImages getImages() {
        return images;
    }

    public void setImages(MovieImages images) {
        this.images = images;
    }

    public List<MovieGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<MovieGenre> genres) {
        this.genres = genres;
    }

    public List<MovieProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<MovieProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public List<MovieProductionCountry> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<MovieProductionCountry> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public List<MovieSpokenLanguage> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(List<MovieSpokenLanguage> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }
}
