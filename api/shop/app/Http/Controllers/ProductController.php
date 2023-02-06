<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Controllers\BaseController as BaseController;
use Validator;
use App\Models\Product;
use App\Http\Resources\Product as ProductResource;

class ProductController extends BaseController {

    public function index() {

        $products = Product::all();

        return $this->sendResponse( ProductResource::collection( $products ), "sajat üzenet" );
    }

    public function show( $id ) {

        $product = Product::find( $id );

        if( is_null( $product )) {

            return $this->sendError( "Termék nem létezik" );
        }

        return $this->sendResponse( new ProductResource( $product ), "üzenet" );
    }

    public function create( Request $request ) {

        $product = $request->all();
        $validator = Validator::make( $product, [

            "name" => "required",
            "itemnumber" => "required",
            "quantity" => "required",
            "price" => "required"
        ]);

        if( $validator->fails() ) {

            return $this-sendError( $validator, "Hiba" );
        }

        $product = Product::create( $product );

        return $this->sendResponse( new ProductResource( $product ), "üzenet" );
    }

    public function update( Request $request, $id ) {

        $input = $request->all();
        $validator = Validator::make( $input, [

            "name" => "required",
            "itemnumber" => "required",
            "quantity" => "required",
            "price" => "required"
        ]);

        if( $validator->fails() ) {

            return $this-sendError( $validator, "Hiba" );
        }

        $product = Product::find( $id );
        // $product->name = $input[ "name" ];
        // $product->itemnumber = $input[ "itemnumber" ];
        // $product->price = $input[ "price" ];
        $product->update( $input );

        return $this->sendResponse( new ProductResource( $product ), "Frissítve" );
    }

    public function destroy( $id ) {

        $product = Product::find( $id );

        $product->delete();

        return $this->sendResponse( new ProductResource( $product ), "Törölve" );
    }
    
}
