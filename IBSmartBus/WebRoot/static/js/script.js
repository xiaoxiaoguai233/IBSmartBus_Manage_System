var scene = new THREE.Scene();
var h = window.innerHeight,
    w = window.innerWidth;
var aspectRatio = w / h,
    fieldOfView = 60,
    nearPlane = .1,
    farPlane = 2000; 
var camera = new THREE.PerspectiveCamera(
    fieldOfView,
    aspectRatio,
    nearPlane,
    farPlane);
var renderer = new THREE.WebGLRenderer({canvas: artboard, alpha: true, antialias: true});
renderer.setSize( w, h );
renderer.shadowMap.enabled = true;
renderer.shadowMap.type = THREE.PCFSoftShadowMap;
document.body.appendChild( renderer.domElement );
//camera
camera.position.set(-300,235,300);
camera.lookAt(new THREE.Vector3(0,0,0));

var Cube = function(x,y,z,mat){
  this.geometry = new THREE.BoxGeometry(x,y,z);
  this.cube=new THREE.Mesh(this.geometry,mat);
  this.cube.castShadow=true;
  // this.cube.receiveShadow=true;
  scene.add(this.cube);
}

function createLights() {
  var light = new THREE.HemisphereLight(0xffffff, 0xffffff, .4);

  var shadowLight = new THREE.DirectionalLight(0xffffff, .8);
  shadowLight.position.set(100, 200, 30);
  shadowLight.castShadow = true;
  
  var d = 200;
  shadowLight.shadow.camera.left = -d;
  shadowLight.shadow.camera.right = d;
  shadowLight.shadow.camera.top = d;
  shadowLight.shadow.camera.bottom = -d;

  
  var backLight = new THREE.DirectionalLight(0xffffff, .4);
  backLight.position.set(-200, 100, 250);
  backLight.castShadow = true;

  scene.add(backLight);
  scene.add(light);
  scene.add(shadowLight);
}
createLights();

var geometry_floor = new THREE.BoxGeometry(300, 10, 300);
// var material_floor = new THREE.MeshBasicMaterial( { color: 0x86D5C7} );
var material_floor = new THREE.ShadowMaterial({opacity:.4});
// var material_floor = new THREE.MeshLambertMaterial( { color: 0x86D5C7} );
var floor = new THREE.Mesh( geometry_floor, material_floor );
floor.position.y=-5;
floor.receiveShadow=true;
scene.add( floor );

//materials
var matBlack = new THREE.MeshLambertMaterial({color:0x493C57});
var matWhite = new THREE.MeshLambertMaterial({color:0xF5F7F4});
var matYellow = new THREE.MeshLambertMaterial({color:0xF7E4A8});
 
function createCar(){
  //wheels
  var wheel = new THREE.Group();
  var wheel_1 = new THREE.Mesh( new THREE.CylinderGeometry( 15, 15, 6, 32 ), matBlack );
  var wheel_2 = new THREE.Mesh( new THREE.CylinderGeometry( 6, 6, 8, 32 ), matWhite );
  wheel.add(wheel_1);
  wheel.add(wheel_2);
  wheel_1.castShadow = true;
  wheel_2.castShadow = true;
  wheel.rotation.z=Math.PI/2;
  wheel.position.set(-35,15,60);
  scene.add( wheel );
  
  var wheel1=wheel.clone();
  wheel1.position.z=-55;
  scene.add( wheel1 );
  
  var wheel2=wheel.clone();
  wheel2.position.z=60;
  wheel2.position.x=35;
  scene.add( wheel2 );
  
  var wheel3=wheel.clone();
  wheel3.position.z=-55;
  wheel3.position.x=35;
  scene.add( wheel3 );

  var underpan=new Cube(105,5,185,matWhite);
  underpan.cube.position.y=30;

  var body=new Cube(100,20,180,matYellow);
  body.cube.position.y=42.5;
  
  
}
createCar();
createBody();

var Gas = function(){
  this.geometry = new THREE.DodecahedronGeometry(20);
  this.gas= new THREE.Mesh( this.geometry, matWhite);
  scene.add( this.gas );
  this.gas.position.z=-112;
  this.gas.position.y=35;
  this.gas.position.x=-20;
  this.lifespan=50;
  this.speed=5;
  this.offsetX=Math.random(1000);
  this.offsetY=Math.random(2000);
  
  this.update=function(){
    this.gas.scale.x*=.95;
    this.gas.scale.y*=.95;
    this.gas.scale.z*=.95;
    
    if(this.speed>1) this.speed*=.95;
    this.gas.position.z-=this.speed;
    this.gas.position.x+=noise.simplex2(this.offsetX,this.offsetY);
    this.gas.position.y+=noise.simplex2(this.offsetY,this.offsetX);
    this.lifespan--;
  }
}

var gases=[];
// function createGas(){
//   gases.push(new Gas());
// }
// createGas();

var count=0;
//render
var render = function(){
  count++;
  if(count<100){
    if(count%8==0) gases.push(new Gas());
  } else if(count>200) {
    count=0;
  }
  
  for(var i=0;i<gases.length;i++){
    gases[i].update();
    if(gases[i].lifespan<0){
      scene.remove(scene.getObjectById(gases[i].gas.id));
      gases.splice(i,1);
    }
  }
	requestAnimationFrame( render );
  renderer.render( scene, camera );
}
render();

// function customizeShadow(t,a){ //target mesh, opacity
//   var material_shadow = new THREE.ShadowMaterial({opacity:a});
//   var mesh_shadow = new THREE.Mesh( t.geometry, material_shadow );
//   mesh_shadow.position.set(t.position.x,t.position.y,t.position.z);
//   mesh_shadow.receiveShadow = true;
//   scene.add( mesh_shadow );
// }

// left
// camera.position.set(-400,80,0); 
// camera.lookAt(new THREE.Vector3(0,80,0));
//front
// camera.position.set(0,80,300); 
// camera.lookAt(new THREE.Vector3(0,80,0));
//top
// camera.position.set(0,500,0); 
// camera.lookAt(new THREE.Vector3(0,0,0));


function createBody(){
  
  //outline
  var outline_shape = new THREE.Shape();
  outline_shape.moveTo( 50,0 );
  outline_shape.lineTo( 30,60 );
  outline_shape.lineTo( -40, 60 );
  outline_shape.lineTo( -50, 0 );
  outline_shape.lineTo( 50, 0 );

  var outline_extrude_settings = {
    steps: 1,
    depth: 94,
    bevelEnabled: false,
  };

  var outline_extrude_geometry = new THREE.ExtrudeGeometry( outline_shape, outline_extrude_settings );
  var outline_extrude_mesh = new THREE.Mesh( outline_extrude_geometry, matYellow ) ;
  // scene.add( outline_extrude_mesh );
  
  var geometry_box = new THREE.BoxGeometry(60, 50, 84);//x,50,84
  var mesh_box= new THREE.Mesh( geometry_box, matBlack);
  mesh_box.position.z=47;
  mesh_box.position.y=30;
  mesh_box.position.x=50;
  // scene.add( mesh_box );
  
  
  var bPillar=0;
  var frontWindow_shape = new THREE.Shape();
  frontWindow_shape.moveTo(45,5);
  frontWindow_shape.lineTo(25,55);
  frontWindow_shape.lineTo(bPillar,55);
  frontWindow_shape.lineTo(bPillar,5);
  frontWindow_shape.lineTo(45,5);
  
  var rearWindow_shape = new THREE.Shape();
  rearWindow_shape.moveTo(bPillar-5,5);
  rearWindow_shape.lineTo(bPillar-5,55)
  rearWindow_shape.lineTo(-35,55);
  rearWindow_shape.lineTo(-45,5);
  rearWindow_shape.lineTo(bPillar-5,5);
  
  var window_negative_extrude_settings = {
    steps: 1,
    depth: 100,
    bevelEnabled: false,
  };
  
  var frontWindow_negative_extrude_geometry = new THREE.ExtrudeGeometry( frontWindow_shape, window_negative_extrude_settings );
  var frontWindow_negative_extrude_mesh = new THREE.Mesh( frontWindow_negative_extrude_geometry, matBlack ) ;
  // scene.add( frontWindow_negative_extrude_mesh );
  
  var rearWindow_negative_extrude_geometry = new THREE.ExtrudeGeometry( rearWindow_shape, window_negative_extrude_settings );
  var rearWindow_negative_extrude_mesh = new THREE.Mesh( rearWindow_negative_extrude_geometry, matBlack ) ;
  // scene.add( rearWindow_negative_extrude_mesh );
  
  var outline=subtract(outline_extrude_mesh,mesh_box);
  outline=subtract(outline,frontWindow_negative_extrude_mesh);
  outline=subtract(outline,rearWindow_negative_extrude_mesh);
  
  outline.rotation.y=-Math.PI/2;
  outline.position.y=52;
  outline.position.x=47;
  outline.castShadow=true;
  scene.add( outline );
}

function subtract(mesh1,mesh2) { //mesh1-mesh2
  var mesh_extrude_csg = THREE.CSG.fromMesh(mesh1);
  var mesh_box_csg = THREE.CSG.fromMesh(mesh2);
  var result_csg = mesh_extrude_csg.subtract(mesh_box_csg);
  var result_mesh = THREE.CSG.toMesh(result_csg,matYellow);
  return result_mesh;
}


// # convert THREE.Geometry to CSG format
// var csg = THREE.CSG.fromGeometry(geometry)

// # convert THREE.Mesh to CSG format
// var csg = THREE.CSG.fromMesh(mesh)

// # convert to THREE.Geometry
// var geometry = THREE.CSG.toGeometry(csg)

// # convert to THREE.Mesh
// var mesh = THREE.CSG.toMesh(csg, material)