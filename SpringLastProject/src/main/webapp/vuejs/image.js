const image_card={
		   template:`<div class="col-md-3" v-for="vo in $parent.list">
		    <div class="thumbnail">
		      <a href="#">
		        <img :src="vo.poster" alt="Lights" style="width:230px;height: 130px;">
		        <div class="caption">
		          <p>{{vo.name}}</p>
		        </div>
		      </a>
		    </div>
		  </div>` 
   }