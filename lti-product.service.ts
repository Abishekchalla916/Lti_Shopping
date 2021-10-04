import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LtiProduct } from './lti-product/LtiProduct';
import { Observable } from 'rxjs';
import { LtiRetailer } from './lti-product/LtiRetailer';
import { orderDto } from './lti-cart/dto';


@Injectable({
  providedIn: 'root'
})
export class LtiProductService {

  baseUrl="http://localhost:8080/";
  constructor(private myHttp:HttpClient) { }
  loadAllProductsService():Observable<LtiProduct[]> {
    console.log("In load prod service...");
    return this.myHttp.get<LtiProduct[]>(this.baseUrl+"getJPAProds/");
  }
  //: Observable<LtiProduct[]>
  loadSingleProductService(prodId: number) : Observable<LtiProduct>{
    console.log("In load prod service...");
    return this.myHttp.get<LtiProduct>(this.baseUrl+"getJPAProd/"+prodId);
  }

  deleteProdByIDService(prodId : number): Observable<String>{
    console.log("Deleting a product in service() "+prodId);
    //this.myHttp.post
    return this.myHttp.get<String>(this.baseUrl+"deleteJPAProd/"+prodId);
  }

  addProduct(prod : LtiProduct,retailerId : number){
    console.log("adding product...."+prod);
    return this.myHttp.post(this.baseUrl+"addJPAProd/"+retailerId,prod);
  }

  loadSingleRetailerService(retailerId : number) : Observable<LtiRetailer>{
    console.log("In get retailer service...");
    return this.myHttp.get<LtiRetailer>(this.baseUrl+"getRetailer/"+retailerId)
  }

  singleProdToShow : LtiProduct=new LtiProduct();
  setSingleProdToShowService(prod:LtiProduct){
    this.singleProdToShow=prod;
  }
  getSingleProdToShowService(){
    console.log(this.singleProdToShow);
    console.log("In load prod service...");
    return this.singleProdToShow;
  }

  cartProds:LtiProduct[]=[];
  setCart(prods :LtiProduct[] ){
    this.cartProds=prods;
    console.log("Setting cart....");
  }

  getCart(){
    console.log("Getting cart..."+this.cartProds);
    console.log("In load prod service...");
    return this.cartProds;
  }
  
  orderProds:LtiProduct[]=[];
  quantity:number[]=[];
  setOrder(prods : LtiProduct[],qty : number[]){
    this.orderProds=prods;
    this.quantity=qty;
  }

  getOrderProducts(){
    return this.orderProds;
  }

  getOrderQuantities(){
    return this.quantity;
  }

  placeOrderService(dto : orderDto){
    return this.myHttp.post(this.baseUrl+"addUserOrder/"+"Jaya@gmail.com",dto);
  }

  compareProds:LtiProduct[]=[];
  setCompareProducts( prods:LtiProduct[]=[]){
    this.compareProds=prods;
  }

  getCompareProducts(){
    return this.compareProds;
  }
  


}