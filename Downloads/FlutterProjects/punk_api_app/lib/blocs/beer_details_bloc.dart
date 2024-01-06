// lib/blocs/beer_details_bloc.dart
import 'dart:async';
import '../models/beer_model.dart';
import '../services/api_service.dart';

class BeerDetailsBloc {
  final _apiService = ApiService();
  final _beerDetailsController = StreamController<BeerModel>.broadcast();

  Stream<BeerModel> get beerDetailsStream => _beerDetailsController.stream;

  void fetchBeerDetails(int beerId) async {
    try {
      // Fetch beer details by ID
      BeerModel beer = await _apiService.fetchBeerDetails(beerId);
      _beerDetailsController.add(beer);
    } catch (e) {
      // Handle error
      print('Error fetching beer details: $e');
    }
  }

  void dispose() {
    _beerDetailsController.close();
  }
}

final beerDetailsBloc = BeerDetailsBloc();
