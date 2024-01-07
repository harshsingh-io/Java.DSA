// lib/services/api_service.dart
import 'dart:convert';
import 'package:http/http.dart' as http;
import '../models/beer_model.dart';
import '../utils/constants.dart';

class ApiService {
  Future<List<BeerModel>> fetchBeers() async {
    try {
      final response =
          await http.get(Uri.parse('${Constants.apiBaseUrl}beers'));

      if (response.statusCode == 200) {
        // Parse JSON data into a list of BeerModel
        final List<dynamic> data = json.decode(response.body);
        final List<BeerModel> beers =
            data.map((json) => BeerModel.fromJson(json)).toList();
        return beers;
      } else {
        // Print details for debugging and throw an exception
        print('Failed to load beers. Status code: ${response.statusCode}');
        print('Response body: ${response.body}');
        throw Exception('Failed to load beers');
      }
    } catch (e) {
      // Catch any unexpected errors
      print('Error during API request: $e');
      throw Exception('Failed to load beers');
    }
  }

  Future<BeerModel> fetchBeerDetails(int beerId) async {
    try {
      final response =
          await http.get(Uri.parse('${Constants.apiBaseUrl}beers/$beerId'));

      if (response.statusCode == 200) {
        // Parse JSON data into a BeerModel
        Map<String, dynamic> data = json.decode(response.body)[0];
        BeerModel beer = BeerModel.fromJson(data);
        return beer;
      } else {
        // Print details for debugging and throw an exception
        print(
            'Failed to load beer details. Status code: ${response.statusCode}');
        print('Response body: ${response.body}');
        throw Exception('Failed to load beer details');
      }
    } catch (e) {
      // Catch any unexpected errors
      print('Error during API request: $e');
      throw Exception('Failed to load beer details');
    }
  }
}
