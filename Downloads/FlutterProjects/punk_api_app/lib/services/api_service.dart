// lib/services/api_service.dart
import 'dart:convert';
import 'package:http/http.dart' as http;
import '../models/beer_model.dart';
import '../utils/constants.dart';

class ApiService {
  Future<List<BeerModel>> fetchBeers() async {
    final response = await http.get(Uri.parse('${Constants.apiBaseUrl}beers'));

    if (response.statusCode == 200) {
      List<dynamic> data = json.decode(response.body);
      List<BeerModel> beers = data.map((json) => BeerModel.fromJson(json)).toList();
      return beers;
    } else {
      throw Exception('Failed to load beers');
    }
  }
  
  Future<BeerModel> fetchBeerDetails(int beerId) async {
    final response = await http.get(Uri.parse('${Constants.apiBaseUrl}beers/$beerId'));

    if (response.statusCode == 200) {
      Map<String, dynamic> data = json.decode(response.body)[0];
      BeerModel beer = BeerModel.fromJson(data);
      return beer;
    } else {
      throw Exception('Failed to load beer details');
    }
  }
}
