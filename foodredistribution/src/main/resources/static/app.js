function addFood(){
 fetch("/api/food",{
  method:"POST",
  headers:{"Content-Type":"application/json"},
  body:JSON.stringify({
   hotelName:hotel.value,
   foodName:food.value,
   quantity:qty.value,
   expiryTime:expiry.value
  })
 }).then(r=>r.json())
   .then(d=>alert("Food Added"));
}

function loadFood(){
 fetch("/api/food")
 .then(r=>r.json())
 .then(data=>{
  list.innerHTML="";
  data.forEach(f=>{
   list.innerHTML+=`
    <div class="food-card">
      <div>
        <b>${f.foodName}</b> (${f.quantity})<br>
         ${f.hotelName}
      </div>
      <button onclick="pickup(${f.id})">Pickup</button>
    </div>`;
  });
 });
}

function pickup(id){
 fetch(`/api/pickup/${id}?ngoName=HelpingHands`,{method:"POST"})
 .then(r=>r.json())
 .then(d=>alert("Pickup Requested"));
}
