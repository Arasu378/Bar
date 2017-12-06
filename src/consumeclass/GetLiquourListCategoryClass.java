package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import utils.Constants;
import utils.LiquorKey;

import com.arasu.LiquorDataClass;
import com.arasu.LiquorResponse;

public class GetLiquourListCategoryClass {
	public static LiquorResponse getLiquor(String category) {
		ArrayList<LiquorDataClass>list=new ArrayList<LiquorDataClass>();
		LiquorResponse userfirst=new LiquorResponse();
		list.clear();
		 Connection connection=null;
		 try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		 try{
			 connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
//			   String query="CALL get_liquorList();";
			 category="'"+category+"'";
			 String query="CALL getliquorlist_category("+category+");";
			 System.out.println("Query: "+query);
			   java.sql.Statement st=connection.createStatement();
			   ResultSet rs=st.executeQuery(query);
			   while(rs.next()){
				   LiquorDataClass dataclass=new LiquorDataClass();
				   int Id=rs.getInt(LiquorKey._id);
				   int LocalId=rs.getInt(LiquorKey.local_id);
				   String BaseUri=rs.getString(LiquorKey.base_uri);
				   if(BaseUri==null){
					   BaseUri="";
				   }
				   int ParId=rs.getInt(LiquorKey.par_id);
				   String ParentParId=rs.getString(LiquorKey.parent_par_id);
				   	if(ParentParId==null){
				   		ParentParId="";
				   	}
				   String ParOrder=rs.getString(LiquorKey.par_order);
				   if(ParOrder==null){
					   ParOrder="";
				   }
				   String ModCount=rs.getString(LiquorKey.mod_count);
				   if(ModCount==null){
					   ModCount="";
				   }
				   String LastUpdatedServer=rs.getString(LiquorKey.last_updated_server);
				   if(LastUpdatedServer==null){
					   LastUpdatedServer="";
				   }
				   String LocalDelete=rs.getString(LiquorKey.local_delete);
				   if(LocalDelete==null){
					   LocalDelete="";
				   }
				   String AlcoholSubType=rs.getString(LiquorKey.alcohol_subtype);
				   if(AlcoholSubType==null){
					   AlcoholSubType="";
				   }
				   String AlcoholType=rs.getString(LiquorKey.alcohol_type);
				   if(AlcoholType==null){
					   AlcoholType="";
				   }
				   String AsciiName=rs.getString(LiquorKey.ascii_name);
				   if(AsciiName==null){
					   AsciiName="";
				   }
				   String BinNumber=rs.getString(LiquorKey.bin_number);
				   if(BinNumber==null){
					   BinNumber="";
				   }
				   int CapacityML=rs.getInt(LiquorKey.capacity_mL);
				   
				   String ContainerType=rs.getString(LiquorKey.container_type);
				   if(ContainerType==null){
					   ContainerType="";
				   }
				   String CreatedAt=rs.getString(LiquorKey.created_at);
				   if(CreatedAt==null){
					   CreatedAt="";
				   }
				   String DeletedAt=rs.getString(LiquorKey.deleted_at);
				   if(DeletedAt==null){
					   DeletedAt="";
				   }
				   String Establishment=rs.getString(LiquorKey.establishment);
				   if(Establishment==null){
					   Establishment="";
				   }
				   String Image=rs.getString(LiquorKey.image);
				   if(Image==null){
					   Image="";
				   }
				   String LiquidColor=rs.getString(LiquorKey.liquid_color);
				   if(LiquidColor==null){
					   LiquidColor="";
				   }
				   double MaxHeight=rs.getDouble(LiquorKey.max_height);
				   int Measurable=rs.getInt(LiquorKey.measurable);
				   String MediumPictureUrl=rs.getString(LiquorKey.medium_picture_url );
				   if(MediumPictureUrl==null){
					   MediumPictureUrl="";
				   }
				   double MinHeight=rs.getDouble(LiquorKey.min_height);
				   String Name=rs.getString(LiquorKey.name);
				   if(Name==null){
					   Name="";
				   }
				   String PictureUrl=rs.getString(LiquorKey.picture_url);
				   if(PictureUrl==null){
					   PictureUrl="";
				   }
				   String ProductCode=rs.getString(LiquorKey.product_code);
				   if(ProductCode==null){
					   ProductCode="";
				   }
				   String ProductType=rs.getString(LiquorKey.product_type);
				   if(ProductType==null){
					   ProductType="";
				   }
				   String SmallPictureUrl=rs.getString(LiquorKey.small_picture_url);
				   if(SmallPictureUrl==null){
					   SmallPictureUrl="";
				   }
				   String ThumbnailUrl=rs.getString(LiquorKey.thumbnail_url);
				   if(ThumbnailUrl==null){
					   ThumbnailUrl="";
				   }
				   boolean Transparent=rs.getBoolean(LiquorKey.transparent);
				   
				   dataclass.setTransparent(Transparent);
				   dataclass.set_id(Id);
				   dataclass.setLocal_id(LocalId);
				   dataclass.setBase_uri(BaseUri);
				   dataclass.setPar_id(ParId);
				   dataclass.setParent_par_id(ParentParId);
				   dataclass.setPar_order(ParOrder);
				   dataclass.setMod_count(ModCount);
				   dataclass.setLast_updated_server(LastUpdatedServer);
				   dataclass.setLocal_delete(LocalDelete);
				   dataclass.setAlcohol_subtype(AlcoholSubType);
				   dataclass.setAlcohol_type(AlcoholType);
				   dataclass.setAscii_name(AsciiName);
				   dataclass.setBin_number(BinNumber);
				   dataclass.setCapacity_mL(CapacityML);
				   dataclass.setContainer_type(ContainerType);
				   dataclass.setCreated_at(CreatedAt);
				   dataclass.setDeleted_at(DeletedAt);
				   dataclass.setEstablishment(Establishment);
				   dataclass.setImage(Image);
				   dataclass.setLiquid_color(LiquidColor);
				   dataclass.setMax_height(MaxHeight);
				   dataclass.setMeasurable(Measurable);
				   dataclass.setMedium_picture_url(MediumPictureUrl);
				   dataclass.setMin_height(MinHeight);
				   dataclass.setName(Name);
				   dataclass.setPicture_url(PictureUrl);
				   dataclass.setProduct_code(ProductCode);
				   dataclass.setProduct_type(ProductType);
				   dataclass.setSmall_picture_url(SmallPictureUrl);
				   dataclass.setThumbnail_url(ThumbnailUrl);
				   
				   list.add(dataclass);
					System.out.println("It is working");
					userfirst.setIsSuccess(true);
					userfirst.setMessage("");
					userfirst.setUserList(list);
			   }
			   if(list.size()==0){
				   userfirst.setIsSuccess(false);
					userfirst.setMessage("No Liquor List");
					userfirst.setUserList(null);
			   }
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 if(connection!=null){
				 try{
					connection.close(); 
				 }catch(Exception e){
					 e.printStackTrace();
				 }
			 }
		 }
		 return userfirst;
	}
}
